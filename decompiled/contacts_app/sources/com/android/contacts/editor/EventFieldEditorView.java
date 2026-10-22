package com.android.contacts.editor;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.widget.Button;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.datepicker.DatePickerUtils;
import com.android.contacts.datepicker.ODatePickerDialog;
import com.android.contacts.datepicker.OLunarDatePickerDialog;
import com.android.contacts.lunar.LunarCalendar;
import com.android.contacts.lunar.SolarToLunar;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.DataKind;
import com.android.contacts.model.EntityDelta;
import com.android.contacts.util.BytedanceApi;
import com.android.contacts.util.DateUtils;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.bytedance.librarian.LibrarianImpl;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import obric.widget.DatePickerEx;

/* JADX INFO: loaded from: classes.dex */
public class EventFieldEditorView extends LabeledEditorView {
    private static final int DEFAULT_HOUR = 8;
    private Context mContext;
    private Button mDateView;
    private String mNoDateString;
    private int mPrimaryTextColor;
    private int mSecondaryTextColor;

    private int getCalendarMonth(int r1) {
        switch(r1) {
            case 1: goto L26;
            case 2: goto L24;
            case 3: goto L22;
            case 4: goto L20;
            case 5: goto L18;
            case 6: goto L16;
            case 7: goto L14;
            case 8: goto L12;
            case 9: goto L10;
            case 10: goto L8;
            case 11: goto L6;
            case 12: goto L4;
            default: goto L3;
        };
    L3:
        return r1;
    L4:
        return 11;
    L6:
        return 10;
    L8:
        return 9;
    L10:
        return 8;
    L12:
        return 7;
    L14:
        return 6;
    L16:
        return 5;
    L18:
        return 4;
    L20:
        return 3;
    L22:
        return 2;
    L24:
        return 1;
    L26:
        return 0;
    }

    public static int getDefaultHourForBirthday() {
        return 8;
    }

    @Override // com.android.contacts.editor.Editor
    public void changeEditorBackground() {
    }

    static /* synthetic */ Context access$000(EventFieldEditorView r0) {
        return r0.mContext;
    }

    static /* synthetic */ String access$100(EventFieldEditorView r0, int r1, int r2, int r3, boolean r4) {
        return r0.getDateString(r1, r2, r3, r4);
    }

    static /* synthetic */ String access$200(EventFieldEditorView r0, int r1, int r2, int r3, boolean r4, String r5, String r6) {
        return r0.getDateString(r1, r2, r3, r4, r5, r6);
    }

    static /* synthetic */ void access$300(EventFieldEditorView r0) {
        r0.rebuildDateView();
    }

    @Override // com.android.contacts.editor.LabeledEditorView
    protected /* bridge */ /* synthetic */ AccountType.EditType getType() {
        return getType();
    }

    public EventFieldEditorView(Context r1) {
        super(r1);
        this.mContext = r1;
    }

    public EventFieldEditorView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mContext = r1;
    }

    public EventFieldEditorView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mContext = r1;
    }

    @Override // com.android.contacts.editor.LabeledEditorView, android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        Resources r0 = this.mContext.getResources();
        this.mPrimaryTextColor = r0.getColor(R.color.detail_primary_color);
        this.mSecondaryTextColor = r0.getColor(R.color.detail_secondary_color);
        this.mNoDateString = this.mContext.getString(R.string.event_edit_field_hint_text);
        Button r1 = (Button) findViewById(R.id.date_view);
        this.mDateView = r1;
        r1.setOnClickListener(new AnonymousClass1(this));
    }

    @Override // com.android.contacts.editor.LabeledEditorView
    protected void requestFocusForFirstEditField() {
        this.mDateView.requestFocus();
    }

    @Override // com.android.contacts.editor.LabeledEditorView, android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        Button r0 = this.mDateView;
        if (isReadOnly() == true) goto L6;
        if (r2 == false) goto L6;
        boolean r1 = true;
    L7:
        r0.setEnabled(r1);
        return;
    L6:
        r1 = false;
        goto L7
    }

    @Override // com.android.contacts.editor.LabeledEditorView, com.android.contacts.editor.Editor
    public void setValues(DataKind r3, EntityDelta.ValuesDelta r4, EntityDelta r5, boolean r6, ViewIdGenerator r7) {
        boolean r1 = true;
        if (r3.fieldList.size() != 1) goto L32;
        super.setValues(r3, r4, r5, r6, r7);
        Button r8 = this.mDateView;
        if (isEnabled() == false) goto L8;
        if (r6 == true) goto L8;
    L9:
        r8.setEnabled(r1);
        if (this.mState != null) goto L12;
    L29:
        rebuildDateView();
        return;
    L12:
        if (getType() == null) goto L29;
        if (getEntry() == null) goto L29;
        if (getType().rawValue != 4) goto L29;
        if (TextUtils.isEmpty(getEntry().getAsString("data1")) == false) goto L29;
        Iterator<EntityDelta.ValuesDelta> r9 = this.mState.getMimeEntries("vnd.android.cursor.item/contact_event").iterator();
    L21:
        if (r9.hasNext() == false) goto L29;
        EntityDelta.ValuesDelta r10 = r9.next();
        if (r10.getAsInteger(DBHelper.COL_DATA2, -1).intValue() != 3) goto L21;
        if (r10.isVisible() == false) goto L21;
        String r11 = r10.getAsString("data1");
        if (TextUtils.isEmpty(r11) == true) goto L21;
        getEntry().put("data1", r11.replace(LibrarianImpl.Constants.SEPARATOR, "-"));
    L8:
        r1 = false;
        goto L9
    L32:
        throw new IllegalStateException("kind must have 1 field");
    }

    @Override // com.android.contacts.editor.LabeledEditorView
    protected void saveValue(String r7, String r8) {
        super.saveValue(r7, r8);
        if (getType().rawValue != 4) goto L5;
    L6:
        ArrayList<EntityDelta.ValuesDelta> r0 = this.mState.getMimeEntries("vnd.android.cursor.item/contact_event");
        if (r0 == null) goto L36;
        if (r8 == null) goto L37;
        Iterator<EntityDelta.ValuesDelta> r1 = r0.iterator();
    L12:
        if (r1.hasNext() == false) goto L22;
        EntityDelta.ValuesDelta r2 = r1.next();
        if (r2.getAsInteger(DBHelper.COL_DATA2, -1).intValue() != getType().rawValue) goto L12;
        if (r2.isVisible() == false) goto L12;
        Calendar r3 = parseCalendarFromDateString(r8);
        if (r3.get(1) == 0) goto L12;
        if (r3.getTimeInMillis() < SolarToLunar.getBaseTimeMillis(null)) goto L12;
        r2.put(r7, r8);
        goto L12
    L22:
        autoLinkSolarLunar();
        return;
    L37:
        return;
    L36:
        return;
    L5:
        if (getType().rawValue == 3) goto L6;
    }

    public Calendar parseCalendarFromDateString(String r4) {
        SimpleDateFormat r3 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Calendar r0 = Calendar.getInstance();
        Date r5 = r3.parse(r4, new ParsePosition(0));
        if (r5 != null) goto L5;
        r5 = DateUtils.parseDate(r4);
    L5:
        if (r5 == null) goto L7;
        r0.setTime(r5);
    L8:
        return r0;
    L7:
        r0.set(1, 0);
        goto L8
    }

    protected void autoLinkSolarLunar() {
        if (this.mListener == null) goto L6;
        this.mListener.onRequest(5);
        return;
    }

    private void rebuildDateView() {
        String r0 = getKind().fieldList.get(0).column;
        AccountType.EventEditType r2 = getType();
        if (r2 != null) goto L5;
    L7:
        String r3 = DateUtils.formatDate(getContext(), getEntry().getAsString(r0));
    L9:
        if (TextUtils.isEmpty(r3) == true) goto L11;
        this.mDateView.setText(r3);
        this.mDateView.setTextColor(this.mPrimaryTextColor);
        setDeleteButtonVisible(true);
        return;
    L11:
        if (isEmpty() == false) goto L13;
        this.mDateView.setText(this.mNoDateString);
        this.mDateView.setTextColor(getResources().getColor(R.color.detail_hint_color));
        setDeleteButtonVisible(false);
        return;
    L13:
        saveValue(r0, "1-1");
        this.mDateView.setText(LunarCalendar.getLunarDisplayStringFromLunarDateString("1-1"));
        this.mDateView.setTextColor(this.mPrimaryTextColor);
        return;
    L5:
        if (r2.rawValue != 4) goto L7;
        r3 = LunarCalendar.getLunarDisplayStringFromLunarDateString(getEntry().getAsString(r0));
        BytedanceApi.setMaxTextSize(this.mDateView, ContactsUtils.dipTopx(this.mContext, 16.5d));
        goto L9
    }

    @Override // com.android.contacts.editor.Editor
    public boolean isEmpty() {
        if ("vnd.android.cursor.item/contact_event".equals(getKind().mimeType) == false) goto L6;
        String r0 = getKind().fieldList.get(0).column;
        return TextUtils.isEmpty(getEntry().getAsString(r0));
    L6:
        return TextUtils.isEmpty(this.mDateView.getText());
    }

    @Override // com.android.contacts.editor.LabeledEditorView, com.android.contacts.util.DialogManager.DialogShowingView
    public Dialog createDialog(Bundle r3) {
        if (r3 == null) goto L10;
        if (r3.getInt("dialog_id") == R.id.dialog_event_date_picker) goto L8;
        return super.createDialog(r3);
    L8:
        return createDatePickerDialog();
    L10:
        throw new IllegalArgumentException("bundle must not be null");
    }

    @Override // com.android.contacts.editor.LabeledEditorView
    protected AccountType.EventEditType getType() {
        return (AccountType.EventEditType) super.getType();
    }

    @Override // com.android.contacts.editor.LabeledEditorView
    protected void onLabelRebuilt() {
        String r1 = getKind().fieldList.get(0).column;
        String r3 = getEntry().getAsString(r1);
        DataKind r4 = getKind();
        Calendar r12 = Calendar.getInstance();
        int r6 = r12.get(1);
        if (getType().rawValue != 3) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == false) goto L34;
        ArrayList r7 = new ArrayList();
        r7.addAll(this.mState.getMimeEntries("vnd.android.cursor.item/contact_event"));
        if (r7.size() <= 0) goto L34;
        Iterator r8 = r7.iterator();
        int r9 = 0;
    L14:
        if (r8.hasNext() == false) goto L33;
        EntityDelta.ValuesDelta r10 = (EntityDelta.ValuesDelta) r8.next();
        Integer r11 = r10.getAsInteger(DBHelper.COL_DATA2, -1);
        if (r11 == null) goto L14;
        int r13 = r11.intValue();
        String r14 = r10.getAsString(r1);
        if (r10.isDelete() == true) goto L14;
        if (r13 == 3) goto L23;
        if (r13 != 4) goto L14;
    L23:
        if (TextUtils.isEmpty(r14) == true) goto L14;
        if (r13 != getType().rawValue) goto L27;
        r9 = r9 + 1;
    L27:
        Calendar r15 = parseCalendarFromDateString(r14);
        if (r15.get(1) != 0) goto L30;
    L32:
        autoLinkSolarLunar();
        notifyEditorListener();
        goto L14
    L30:
        if (r15.getTimeInMillis() < SolarToLunar.getBaseTimeMillis(null)) goto L32;
        saveValue(r1, r14);
        goto L32
    L33:
        int r16 = r9;
    L36:
        if (getType().isYearOptional() == false) goto L38;
    L45:
        rebuildDateView();
        if (r16 <= 1) goto L61;
        deleteViewQuite();
        return;
    L61:
        return;
    L38:
        if (TextUtils.isEmpty(r3) == true) goto L45;
        ParsePosition r17 = new ParsePosition(0);
        Date r2 = r4.dateFormatWithoutYear.parse(r3, r17);
        if (r2 != null) goto L43;
        return;
    L43:
        if (r17.getIndex() != r3.length()) goto L45;
        r12.setTime(r2);
        r12.set(r6, r12.get(2), r12.get(5), 8, 0, 0);
        onFieldChanged(r1, r4.dateFormatWithYear.format(r12.getTime()));
    L34:
        r16 = 0;
        goto L36
    L5:
        if (getType().rawValue == 4) goto L8;
        r5 = false;
        goto L9
    }

    private Dialog createDatePickerDialog() {
        if (getType().rawValue != 4) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return createLunarDatePickerDialog();
    L9:
        return createSolarDatePickerDialog();
    L5:
        r0 = false;
        goto L6
    }

    private Dialog createSolarDatePickerDialog() {
        final String r0 = getKind().fieldList.get(0).column;
        String r2 = getEntry().getAsString(r0);
        SimpleDateFormat r3 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        if (getType().rawValue != 3) goto L5;
    L8:
        final boolean r4 = true;
    L9:
        Calendar r5 = Calendar.getInstance();
        if (r4 == true) goto L13;
        r5.get(1);
    L13:
        getType().isYearOptional();
        if (TextUtils.isEmpty(r2) == false) goto L16;
        LocalDate r1 = LocalDate.now();
        int r6 = r1.getYear();
        int r7 = r1.getMonthValue();
        int r8 = r1.getDayOfMonth();
    L23:
        DatePickerUtils.OnDateSetListener r9 = new AnonymousClass2(this, r4, r0);
        if (r4 == false) goto L26;
        DatePickerUtils.DatePickerType r10 = DatePickerUtils.DatePickerType.BIRTHDAY;
    L27:
        ODatePickerDialog r11 = new ODatePickerDialog(new ContextThemeWrapper(this.mContext, android.R.style.Theme.DeviceDefault.Light.Dialog.Alert), r9, r6, r7, r8, r10);
        r11.updateDate(r6, r7, r8, r10);
        return r11;
    L26:
        r10 = DatePickerUtils.DatePickerType.EVENT;
        goto L27
    L16:
        Date r12 = r3.parse(r2, new ParsePosition(0));
        if (r12 != null) goto L19;
        r12 = DateUtils.parseDate(r2);
    L19:
        if (r12 == null) goto L21;
        LocalDate r13 = r12.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    L22:
        r6 = r13.getYear();
        r7 = r13.getMonthValue();
        r8 = r13.getDayOfMonth();
        goto L23
    L21:
        r13 = LocalDate.parse(r2, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        goto L22
    L5:
        if (getType().rawValue == 4) goto L8;
        r4 = false;
        goto L9
    }

    private Dialog createLunarDatePickerDialog() {
        final String r0 = getKind().fieldList.get(0).column;
        String r1 = getEntry().getAsString(r0);
        final SimpleDateFormat r2 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Calendar r3 = Calendar.getInstance();
        if (TextUtils.isEmpty(r1) == false) goto L5;
        LunarCalendar r4 = new LunarCalendar();
        r4.setTimeInMillis(r3.getTimeInMillis());
        r4.setNoYear();
    L6:
        DatePickerUtils.OnLunarDateSetListener r5 = new AnonymousClass3(this, r2, r0);
        return new OLunarDatePickerDialog(new ContextThemeWrapper(this.mContext, android.R.style.Theme.DeviceDefault.Light.Dialog.Alert), r5, r4, DatePickerEx.DatePickerType.BIRTHDAY);
    L5:
        r4 = LunarCalendar.parseLunarDate(r1);
        goto L6
    }

    private String getDateString(int r8, int r9, int r10, boolean r11) {
        return getDateString(r8, r9, r10, r11, "yyyy/MM/dd", "MM/dd");
    }

    private String getDateString(int r10, int r11, int r12, boolean r13, String r14, String r15) {
        if (r10 != 0) goto L5;
        int r1 = 1900;
    L6:
        LocalDate r2 = LocalDate.of(r1, r11, r12);
        DateTimeFormatter r16 = DateTimeFormatter.ofPattern(r14);
        if (r13 == false) goto L9;
        r16 = DateTimeFormatter.ofPattern(r15);
    L9:
        Calendar r3 = Calendar.getInstance(getKind().dateFormatWithYear.getTimeZone());
        if (r10 != 0) goto L12;
        int r4 = 1900;
    L13:
        r3.set(r4, getCalendarMonth(r11), r12, 8, 0, 0);
        return r2.format(r16);
    L12:
        r4 = r10;
        goto L13
    L5:
        r1 = r10;
        goto L6
    }

    @Override // com.android.contacts.editor.Editor
    public void clearAllFields() {
        this.mDateView.setText(this.mNoDateString);
        this.mDateView.setTextColor(this.mSecondaryTextColor);
        onFieldChanged(getKind().fieldList.get(0).column, "");
    }

    @Override // com.android.contacts.editor.LabeledEditorView
    protected void performAddFieldAction() {
        super.performAddFieldAction();
        this.mDateView.performClick();
    }
}
