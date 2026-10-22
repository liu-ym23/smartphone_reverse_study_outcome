package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.android.material.internal.r;
import com.google.android.material.textfield.TextInputLayout;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public class RangeDateSelector implements DateSelector<androidx.core.util.e<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = null;
    private final String invalidRangeEndError;
    private String invalidRangeStartError;
    private Long proposedTextEnd;
    private Long proposedTextStart;
    private Long selectedEndItem;
    private Long selectedStartItem;

    private boolean isValidRange(long r1, long r3) {
        if (r1 > r3) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public /* bridge */ /* synthetic */ androidx.core.util.e<Long, Long> getSelection() {
        return getSelection();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public /* synthetic */ void setSelection(androidx.core.util.e<Long, Long> r3) {
        setSelection2((androidx.core.util.e) ZeusTransformUtils.preCheckCast(r3, androidx.core.util.e.class, "com.obric.aiagent.plugin"));
    }

    public RangeDateSelector() {
        this.invalidRangeEndError = " ";
        this.selectedStartItem = null;
        this.selectedEndItem = null;
        this.proposedTextStart = null;
        this.proposedTextEnd = null;
    }

    static /* synthetic */ Long access$002(RangeDateSelector r0, Long r1) {
        r0.proposedTextStart = r1;
        return r1;
    }

    static /* synthetic */ void access$100(RangeDateSelector r0, TextInputLayout r1, TextInputLayout r2, f r3) {
        r0.updateIfValidTextProposal(r1, r2, r3);
    }

    static /* synthetic */ Long access$202(RangeDateSelector r0, Long r1) {
        r0.proposedTextEnd = r1;
        return r1;
    }

    static /* synthetic */ Long access$302(RangeDateSelector r0, Long r1) {
        r0.selectedStartItem = r1;
        return r1;
    }

    static /* synthetic */ Long access$402(RangeDateSelector r0, Long r1) {
        r0.selectedEndItem = r1;
        return r1;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void select(long r3) {
        Long r0 = this.selectedStartItem;
        if (r0 != null) goto L6;
        this.selectedStartItem = Long.valueOf(r3);
        return;
    L6:
        if (this.selectedEndItem == null) goto L8;
    L10:
        this.selectedEndItem = null;
        this.selectedStartItem = Long.valueOf(r3);
        return;
    L8:
        if (isValidRange(r0.longValue(), r3) == false) goto L10;
        this.selectedEndItem = Long.valueOf(r3);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean isSelectionComplete() {
        Long r0 = this.selectedStartItem;
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (this.selectedEndItem == null) goto L9;
        if (isValidRange(r0.longValue(), this.selectedEndItem.longValue()) == false) goto L9;
        return true;
    }

    /* JADX INFO: renamed from: setSelection, reason: avoid collision after fix types in other method */
    public void setSelection2(androidx.core.util.e<Long, Long> r7) {
        if (r7.f1371a != null) goto L5;
    L7:
        Long r2 = null;
        if (r7.f1371a != null) goto L10;
        Long r0 = null;
    L11:
        this.selectedStartItem = r0;
        if (r7.f1372b == null) goto L15;
        r2 = Long.valueOf(i.a(((Long) ZeusTransformUtils.preCheckCast(r7.f1372b, Long.class, "com.obric.aiagent.plugin")).longValue()));
    L15:
        this.selectedEndItem = r2;
        return;
    L10:
        r0 = Long.valueOf(i.a(((Long) ZeusTransformUtils.preCheckCast(r7.f1371a, Long.class, "com.obric.aiagent.plugin")).longValue()));
        goto L11
    L5:
        if (r7.f1372b == null) goto L7;
        androidx.core.util.g.a(isValidRange(((Long) ZeusTransformUtils.preCheckCast(r7.f1371a, Long.class, "com.obric.aiagent.plugin")).longValue(), ((Long) ZeusTransformUtils.preCheckCast(r7.f1372b, Long.class, "com.obric.aiagent.plugin")).longValue()));
        goto L7
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.material.datepicker.DateSelector
    public androidx.core.util.e<Long, Long> getSelection() {
        return new androidx.core.util.e(this.selectedStartItem, this.selectedEndItem);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection<androidx.core.util.e<Long, Long>> getSelectedRanges() {
        if (this.selectedStartItem == null) goto L10;
        if (this.selectedEndItem == null) goto L10;
        ArrayList r0 = new ArrayList();
        r0.add(new androidx.core.util.e(this.selectedStartItem, this.selectedEndItem));
        return r0;
    L10:
        return new ArrayList();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection<Long> getSelectedDays() {
        ArrayList r0 = new ArrayList();
        Long r1 = this.selectedStartItem;
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        Long r2 = this.selectedEndItem;
        if (r2 == null) goto L8;
        r0.add(r2);
    L8:
        return r0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultThemeResId(Context r5) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        Resources r6 = ZeusTransformUtils.getResources(r4, "com.obric.aiagent.plugin");
        DisplayMetrics r0 = r6.getDisplayMetrics();
        int r7 = r6.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis, "dimen", "mtrl_calendar_maximum_default_fullscreen_minor_axis"));
        if (Math.min(r0.widthPixels, r0.heightPixels) <= r7) goto L5;
        int r8 = ZeusTransformUtils.mapRes(R.attr.materialCalendarTheme, "attr", "materialCalendarTheme");
    L7:
        return com.google.android.material.g.b.a(r4, r8, MaterialDatePicker.class.getCanonicalName());
    L5:
        r8 = ZeusTransformUtils.mapRes(R.attr.materialCalendarFullscreenTheme, "attr", "materialCalendarFullscreenTheme");
        goto L7
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String getSelectionDisplayString(Context r7) {
        Resources r8 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        Long r0 = this.selectedStartItem;
        if (r0 == null) goto L5;
    L8:
        Long r2 = this.selectedEndItem;
        if (r2 == null) goto L11;
        if (r0 == null) goto L14;
        androidx.core.util.e<String, String> r6 = c.a(r0, r2);
        return r8.getString(ZeusTransformUtils.mapRes(R.string.mtrl_picker_range_header_selected, WsChannelMultiProcessSharedProvider.STRING_TYPE, "mtrl_picker_range_header_selected"), new Object[]{r6.f1371a, r6.f1372b});
    L14:
        return r8.getString(ZeusTransformUtils.mapRes(R.string.mtrl_picker_range_header_only_end_selected, WsChannelMultiProcessSharedProvider.STRING_TYPE, "mtrl_picker_range_header_only_end_selected"), new Object[]{c.f(this.selectedEndItem.longValue())});
    L11:
        return r8.getString(ZeusTransformUtils.mapRes(R.string.mtrl_picker_range_header_only_start_selected, WsChannelMultiProcessSharedProvider.STRING_TYPE, "mtrl_picker_range_header_only_start_selected"), new Object[]{c.f(this.selectedStartItem.longValue())});
    L5:
        if (this.selectedEndItem != null) goto L8;
        return r8.getString(ZeusTransformUtils.mapRes(R.string.mtrl_picker_range_header_unselected, WsChannelMultiProcessSharedProvider.STRING_TYPE, "mtrl_picker_range_header_unselected"));
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultTitleResId() {
        return ZeusTransformUtils.mapRes(R.string.mtrl_picker_range_header_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "mtrl_picker_range_header_title");
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View onCreateTextInputView(LayoutInflater r18, ViewGroup r19, Bundle r20, final CalendarConstraints r21, final f<androidx.core.util.e<Long, Long>> r22) {
        View r10 = ZeusTransformUtils.inflate(r18, ZeusTransformUtils.mapRes(R.layout.mtrl_picker_text_input_date_range, "layout", "mtrl_picker_text_input_date_range"), r19, false, "com.obric.aiagent.plugin");
        final TextInputLayout r11 = (TextInputLayout) ZeusTransformUtils.preCheckCast(r10.findViewById(ZeusTransformUtils.mapRes(R.id.mtrl_picker_text_input_range_start, DbHelper.COL_ID, "mtrl_picker_text_input_range_start")), TextInputLayout.class, "com.obric.aiagent.plugin");
        final TextInputLayout r12 = (TextInputLayout) ZeusTransformUtils.preCheckCast(r10.findViewById(ZeusTransformUtils.mapRes(R.id.mtrl_picker_text_input_range_end, DbHelper.COL_ID, "mtrl_picker_text_input_range_end")), TextInputLayout.class, "com.obric.aiagent.plugin");
        EditText r13 = r11.getEditText();
        EditText r14 = r12.getEditText();
        if (com.google.android.material.internal.f.d() == false) goto L5;
        r13.setInputType(17);
        r14.setInputType(17);
    L5:
        this.invalidRangeStartError = ZeusTransformUtils.getResources(r10, "com.obric.aiagent.plugin").getString(ZeusTransformUtils.mapRes(R.string.mtrl_picker_invalid_range, WsChannelMultiProcessSharedProvider.STRING_TYPE, "mtrl_picker_invalid_range"));
        final SimpleDateFormat r15 = i.d();
        Long r0 = this.selectedStartItem;
        if (r0 == null) goto L8;
        r13.setText(r15.format(r0));
        this.proposedTextStart = this.selectedStartItem;
    L8:
        Long r1 = this.selectedEndItem;
        if (r1 == null) goto L11;
        r14.setText(r15.format(r1));
        this.proposedTextEnd = this.selectedEndItem;
    L11:
        final String r8 = i.a(ZeusTransformUtils.getResources(r10, "com.obric.aiagent.plugin"), r15);
        r11.setPlaceholderText(r8);
        r12.setPlaceholderText(r8);
        r13.addTextChangedListener(new AnonymousClass1(this, r8, r15, r11, r21, r11, r12, r22));
        r14.addTextChangedListener(new AnonymousClass2(this, r8, r15, r12, r21, r11, r12, r22));
        r.b(r13);
        return r10;
    }

    private void updateIfValidTextProposal(TextInputLayout r5, TextInputLayout r6, f<androidx.core.util.e<Long, Long>> r7) {
        Long r0 = this.proposedTextStart;
        if (r0 != null) goto L5;
    L12:
        clearInvalidRange(r5, r6);
        r7.a();
        return;
    L5:
        if (this.proposedTextEnd == null) goto L12;
        if (isValidRange(r0.longValue(), this.proposedTextEnd.longValue()) == false) goto L10;
        this.selectedStartItem = this.proposedTextStart;
        this.selectedEndItem = this.proposedTextEnd;
        r7.a(getSelection());
        return;
    L10:
        setInvalidRange(r5, r6);
        r7.a();
    }

    private void clearInvalidRange(TextInputLayout r3, TextInputLayout r4) {
        if (r3.getError() == null) goto L8;
        if (this.invalidRangeStartError.contentEquals(r3.getError()) == false) goto L8;
        r3.setError(null);
    L8:
        if (r4.getError() != null) goto L10;
        return;
    L10:
        if (" ".contentEquals(r4.getError()) == false) goto L14;
        r4.setError(null);
        return;
    }

    private void setInvalidRange(TextInputLayout r1, TextInputLayout r2) {
        r1.setError(this.invalidRangeStartError);
        r2.setError(" ");
    }

    static {
        CREATOR = new AnonymousClass3();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeValue(this.selectedStartItem);
        r1.writeValue(this.selectedEndItem);
    }
}
