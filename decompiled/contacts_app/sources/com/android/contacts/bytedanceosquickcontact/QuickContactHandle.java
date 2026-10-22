package com.android.contacts.bytedanceosquickcontact;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.android.contacts.ContactsApplication;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.R;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.Constants;
import com.android.contacts.util.HanziToPinyin;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.v2.action.OActionDialog;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.sheet.OInsetSheetTitleBar;
import com.obric.tracker.CallScreenShowUtils;
import com.obric.tracker.event.CallScreenShowEvent;
import com.obric.ui.dialog.OUIDialogHelper;
import com.obric.ui.dialog.action.ActionButtonStyle;
import com.obric.ui.dialog.action.ActionDialogItemData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import obric.app.tracker.Agent;

/* JADX INFO: loaded from: classes.dex */
public class QuickContactHandle {
    public static final int ACTION_CALL = 0;
    public static final int ACTION_MMS = 1;
    public static final int ACTION_STAR = 2;
    private Context mContext;
    private Handler mHandler;
    private OInsetSheet mSelectionSheet;
    private OActionDialog mStarActionDialog;

    public interface Callback {
        void onPlaceActionsEnd();
    }

    static /* synthetic */ Context access$000(QuickContactHandle r0) {
        return r0.mContext;
    }

    static /* synthetic */ void access$100(QuickContactHandle r0, Intent r1) {
        r0.startActivity(r1);
    }

    static /* synthetic */ void access$200(QuickContactHandle r0, List r1, Callback r2) {
        r0.setStar(r1, r2);
    }

    static /* synthetic */ void access$300(QuickContactHandle r0, Action r1, String r2) {
        r0.processStarAction(r1, r2);
    }

    static /* synthetic */ void access$400(QuickContactHandle r0) {
        r0.dismissSelectionDialog();
    }

    static /* synthetic */ void access$500(QuickContactHandle r0) {
        r0.dismissStarActionDialog();
    }

    static /* synthetic */ OInsetSheet access$600(QuickContactHandle r0) {
        return r0.mSelectionSheet;
    }

    public QuickContactHandle(Context r1) {
        this.mContext = r1;
        this.mHandler = new Handler();
    }

    public void placeCallActions(final ArrayList<Action> r2, final int r3, final String r4) {
        Runnable r0 = new AnonymousClass1(this, r2, r4, r3);
        this.mHandler.post(r0);
    }

    public void placeMmsActions(final ArrayList<Action> r2) {
        Runnable r0 = new AnonymousClass2(this, r2);
        this.mHandler.post(r0);
    }

    public void placeStarActions(final List<Action> r2, final Callback r3) {
        Runnable r0 = new AnonymousClass3(this, r2, r3);
        this.mHandler.post(r0);
    }

    public void placeStarActions(List<Action> r2, List<Action> r3, Callback r4) {
        ArrayList r0 = new ArrayList();
        if (r2 == null) goto L5;
        r0.addAll(r2);
    L5:
        if (r3 == null) goto L7;
        r0.addAll(r3);
    L7:
        placeStarActions(r0, r4);
    }

    private void setStar(final List<Action> r3, final Callback r4) {
        new Handler().postDelayed(new AnonymousClass4(this, r3, r4), 200);
    }

    public void placeWechatActions(Action r4) {
        Agent.getInstance().onClick("DialtactsActivity", Constants.ContactsTracker.EVENT_WECHAT);
        Uri r0 = ContentUris.withAppendedId(ContactsContract.Data.CONTENT_URI, r4.getDataId());
        Intent r1 = new Intent("android.intent.action.VIEW");
        r1.setDataAndType(r0, r4.getMimeType());
        this.mContext.startActivity(r1);
    }

    public void showSelectionDialog(final int r12, List<Action> r13, final int r14, final String r15) {
        if (r12 != 2) goto L6;
        showStarActionDialog(r13, r15);
        return;
    L6:
        OInsetSheet r0 = this.mSelectionSheet;
        if (r0 != null) goto L9;
    L11:
        int r1 = R.string.dialog_title_call;
        if (r12 != 0) goto L14;
    L17:
        ArrayList r2 = new ArrayList();
        Iterator<Action> r3 = r13.iterator();
    L19:
        if (r3.hasNext() == false) goto L23;
        String r4 = getActionDisplayText(r12, r3.next());
        if (r2.contains(r4) == true) goto L19;
        r2.add(r4);
        goto L19
    L23:
        if (r12 != 0) goto L44;
        Cursor r5 = this.mContext.getContentResolver().query(CallLog.Calls.CONTENT_URI, new String[]{"number"}, getCallLogSelection(r2), null, "date desc limit 1");
        if (r5 != null) goto L27;
        String r6 = null;
    L33:
        if (TextUtils.isEmpty(r6) == true) goto L44;
        String r7 = ContactsUtils.formatNumber(r6);
        Iterator<Action> r8 = r13.iterator();
    L36:
        if (r8.hasNext() == false) goto L40;
        Action r9 = r8.next();
        if (r7.equals(ContactsUtils.formatNumber(r9.getData())) == false) goto L36;
        r13.remove(r9);
        r13.add(0, r9);
    L40:
        r2.clear();
        Iterator<Action> r10 = r13.iterator();
    L42:
        if (r10.hasNext() == false) goto L44;
        r2.add(r10.next().getData());
        goto L42
    L27:
        if (r5.moveToNext() == false) goto L29;
        r6 = r5.getString(0);
    L30:
        r5.close();
        goto L33
    L29:
        r6 = null;
    L44:
        ArrayList r11 = new ArrayList();
        Iterator<Action> r16 = r13.iterator();
    L46:
        if (r16.hasNext() == false) goto L48;
        final Action r17 = r16.next();
        r11.add(new AnonymousClass5(this, r12, r17, r14, r15));
        goto L46
    L48:
        OInsetSheet r18 = new OInsetSheet(this.mContext);
        this.mSelectionSheet = r18;
        r18.setRootWidth(OInsetSheet.PanelWidth.NARROW_WIDTH);
        this.mSelectionSheet.setHeaderView(getStartHeaderView(r1));
        this.mSelectionSheet.setContainerView(getStartContentView(r2, r11));
        this.mSelectionSheet.setFooterView(null);
        this.mSelectionSheet.show();
        return;
    L14:
        if (r12 != 1) goto L17;
        r1 = R.string.dialog_title_send;
        goto L17
    L9:
        if (r0.isShowing() == false) goto L11;
        this.mSelectionSheet.dismiss();
        this.mSelectionSheet = null;
        goto L11
    }

    private void showStarActionDialog(List<Action> r4, String r5) {
        dismissStarActionDialog();
        Context r0 = this.mContext;
        OActionDialog r6 = OUIDialogHelper.getActionDialog(r0, r0.getString(R.string.select_phone_number), "", getStarActionItemData(r4, r5), true);
        this.mStarActionDialog = r6;
        r6.show();
    }

    private List<ActionDialogItemData> getStarActionItemData(List<Action> r7, final String r8) {
        ArrayList r0 = new ArrayList();
        Iterator<Action> r9 = r7.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        final Action r1 = r9.next();
        r0.add(new ActionDialogItemData(getActionDisplayText(2, r1), ActionButtonStyle.Neutral, new AnonymousClass6(this, r1, r8)));
        goto L4
    L6:
        r0.add(new ActionDialogItemData(this.mContext.getString(R.string.common_cancel), ActionButtonStyle.Neutral, new AnonymousClass7(this)));
        return r0;
    }

    private View getStartContentView(List<String> r11, List<View.OnClickListener> r12) {
        LinearLayout r0 = new LinearLayout(this.mContext);
        r0.setOrientation(1);
        r0.setPadding(0, 0, 0, ContactsUtils.dipTopx(this.mContext, 5.0d));
        int r1 = Math.min(r11.size(), r12.size());
        int r5 = 0;
    L3:
        if (r5 >= r1) goto L5;
        OButton r6 = (OButton) LayoutInflater.from(this.mContext).inflate(R.layout.sheet_button_left_center_black, null);
        r6.setText(r11.get(r5));
        r6.setOnClickListener(r12.get(r5));
        r6.setWidth(ContactsUtils.dipTopx(this.mContext, 296.0d));
        r6.setHeight(ContactsUtils.dipTopx(this.mContext, 56.0d));
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(-2, -2);
        r7.gravity = 17;
        r7.bottomMargin = ContactsUtils.dipTopx(this.mContext, 5.0d);
        r0.addView(r6, r7);
        r5 = r5 + 1;
        goto L3
    L5:
        r0.setPadding(0, 0, 0, ContactsUtils.dipTopx(this.mContext, 15.0d));
        return r0;
    }

    private View getStartHeaderView(int r3) {
        OInsetSheetTitleBar r0 = new OInsetSheetTitleBar(this.mContext);
        r0.setShowLeftBack(false);
        r0.setTitleText(this.mContext.getString(r3));
        OButton r4 = r0.createNeutralButton(this.mContext, r0.mRightContainer);
        r4.setButtonSourceBitmap(R.drawable.o_ic_close);
        r4.setOnClickListener(new AnonymousClass8(this));
        return r0;
    }

    public void processAction(int r3, Action r4, int r5, String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L6;
        r6 = "DialtactsActivity";
    L6:
        if (r3 == 0) goto L13;
        if (r3 != 1) goto L9;
        Agent.getInstance().onClick(r6, Constants.ContactsTracker.EVENT_SEND_MMS);
        Intent r7 = r4.getAlternateIntent();
        AnimationUtil.startActivity(this.mContext, r7);
        return;
    L9:
        if (r3 != 2) goto L21;
        processStarAction(r4, r6);
        return;
    L21:
        return;
    L13:
        Agent.getInstance().onClick(r6, Constants.ContactsTracker.EVENT_CALL);
        Intent r8 = r4.getIntent();
        if (r5 == 0) goto L16;
        if (1 == r5) goto L16;
    L17:
        startActivity(r8);
        CallScreenShowUtils.INSTANCE.start(new CallScreenShowEvent());
        return;
    L16:
        DSUtils.putSlotIdToIntent(this.mContext, r8, r5);
        goto L17
    }

    private String getActionDisplayText(int r4, Action r5) {
        if (r4 != 2) goto L11;
        if (r5.isStarred().booleanValue() == false) goto L7;
        int r6 = R.string.remove_from_favorites;
    L9:
        return this.mContext.getString(r6, new Object[]{HanziToPinyin.Token.SEPARATOR + r5.getData()});
    L7:
        r6 = R.string.add_to_favorites;
        goto L9
    L11:
        return r5.getData();
    }

    private void processStarAction(Action r3, String r4) {
        Agent.getInstance().onClick(r4, Constants.ContactsTracker.EVENT_STAR);
        this.mContext.startService(r3.getStarIntent());
        if (r3.isStarred().booleanValue() == false) goto L5;
        int r2 = R.string.cancelstarred;
    L6:
        ContactsApplication.showToast(r2, 0);
        return;
    L5:
        r2 = R.string.starredsucceed;
        goto L6
    }

    private void startActivity(Intent r1) {
        if (r1 == null) goto L5;
        this.mContext.startActivity(r1);
        return;
    }

    private void dismissSelectionDialog() {
        OInsetSheet r0 = this.mSelectionSheet;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
        this.mSelectionSheet.dismiss();
    L7:
        this.mSelectionSheet = null;
    }

    private void dismissStarActionDialog() {
        OActionDialog r0 = this.mStarActionDialog;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
        this.mStarActionDialog.dismiss();
    L7:
        this.mStarActionDialog = null;
    }

    public String getCallLogSelection(List<String> r6) {
        boolean r5 = this.mContext.getResources().getBoolean(R.bool.config_use_strict_phone_number_comparation);
        StringBuilder r0 = new StringBuilder("(1 = 0");
        Iterator<String> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r0.append(" OR PHONE_NUMBERS_EQUAL(number,").append("'" + r7.next() + "',").append(r5 ? 1 : 0).append(")");
        goto L4
    L6:
        r0.append(") and type = 2");
        return r0.toString();
    }
}
