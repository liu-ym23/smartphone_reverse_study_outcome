package com.stepos.policy.sdk.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import com.stepos.agentsafetycenter.R;
import com.stepos.common.scrollbarview.StepOSScrollBarView;
import com.stepos.common.scrollview.StepOSNestedScrollView;
import com.stepos.common.widget.Switch;
import com.stepos.policy.sdk.dialog.PolicyPermissionDialogView;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import qe.b;
import qe.c;
import qe.d;
import stepos.support.v7.widget.PermissionScrollView;
import stepos.support.v7.widget.k0;
import t9.g;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class PolicyPermissionViewHandlerImpl23 implements PolicyPermissionViewHandler {
    private CheckBox almostDenyCheckBox;
    private LinearLayout contentLayout;
    private boolean isIntl;
    private final Context mContext;
    private View mDownIndicator;
    private Map<String, Boolean> mItemCheckedMap = new HashMap();
    private final int mItemSummaryColor;
    private final int mItemTitleColor;
    private final LayoutInflater mLayoutInflater;
    private LinearLayout mPermissionContainer;
    private final d mPermissionManager;
    private RelativeLayout mPermissionRelativeLayout;
    private PermissionScrollView mScrollView;
    private final int mTitleColor;
    private View mUpIndicator;
    private StepOSNestedScrollView mzNestedScrollView;
    private StepOSScrollBarView mzScrollBarView;
    private List<c> permissions;
    private TextView reminderTextView;
    private TextView termsView;
    private TextView titleTextView;

    public PolicyPermissionViewHandlerImpl23(Context context) {
        this.mContext = context;
        this.mTitleColor = context.getResources().getColor(R.color.stepos_alert_dialog_title_color_dark);
        this.mItemTitleColor = context.getResources().getColor(R.color.stepos_permission_dialog_item_title_dark);
        this.mItemSummaryColor = context.getResources().getColor(R.color.stepos_permission_dialog_item_summary_dark);
        this.mPermissionManager = d.a(context);
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    private void addGroupItem(ViewGroup viewGroup, String str, String str2, boolean z10) {
        if (this.isIntl) {
            addGroupItemIntl(viewGroup, str, str2, z10);
            return;
        }
        if (viewGroup.getChildCount() != 0) {
            viewGroup.addView(new Space(this.mContext), new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, (float) 22.0d, this.mContext.getResources().getDisplayMetrics())));
        }
        View viewInflate = this.mLayoutInflater.inflate(R.layout.stepos_permission_dialog_item, viewGroup, false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.stepos_permission_dialog_item_title);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.stepos_permission_dialog_item_summary);
        textView.setText(str);
        if (TextUtils.isEmpty(str2)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(str2);
        }
        if (z10) {
            textView.setTextColor(this.mItemTitleColor);
            textView2.setTextColor(this.mItemSummaryColor);
        }
        viewGroup.addView(viewInflate);
    }

    private void addGroupItemIntl(ViewGroup viewGroup, String str, String str2, boolean z10) {
        View viewInflate = this.mLayoutInflater.inflate(R.layout.stepos_permission_dialog_item_intl, viewGroup, false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.switch_title);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.switch_info);
        Switch r32 = (Switch) viewInflate.findViewById(R.id.switch1);
        cb.d dVar = new cb.d(1);
        dVar.f2246f = r32;
        VarHandle.storeStoreFence();
        viewInflate.setOnClickListener(dVar);
        a aVar = new a();
        aVar.f2789a = this;
        aVar.f2790b = str;
        VarHandle.storeStoreFence();
        r32.setOnCheckedChangeListener(aVar);
        textView.setText(str);
        if (TextUtils.isEmpty(str2)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(str2);
        }
        if (z10) {
            textView.setTextColor(this.mItemTitleColor);
            textView2.setTextColor(this.mItemSummaryColor);
        }
        this.mItemCheckedMap.put(str, Boolean.valueOf(r32.isChecked()));
        viewGroup.addView(viewInflate);
    }

    private int getTextWidth(TextView textView, String str) {
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (transformationMethod != null) {
            str = transformationMethod.getTransformation(str, textView).toString();
        }
        return (int) textView.getPaint().measureText(str);
    }

    private boolean isTextViewOneLine(TextView textView) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
        return (getTextWidth(textView, textView.getText().toString()) + (textView.getPaddingRight() + textView.getPaddingLeft())) + (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin) <= this.mContext.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_width);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addGroupItemIntl$1(String str, CompoundButton compoundButton, boolean z10) {
        this.mItemCheckedMap.put(str, Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void manageScrollIndicators(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    @Override // com.stepos.policy.sdk.dialog.PolicyPermissionViewHandler
    public void bindData(PolicyPermissionDialogView.Builder builder) throws Resources.NotFoundException {
        String[] strArr;
        boolean z10 = builder.mShowTitle;
        TextView textView = this.titleTextView;
        if (z10) {
            textView.setText(builder.appName);
            if (isTextViewOneLine(this.titleTextView)) {
                this.titleTextView.setGravity(17);
            }
        } else {
            textView.setVisibility(8);
        }
        if (builder.isDark) {
            this.titleTextView.setTextColor(this.mTitleColor);
        }
        this.isIntl = builder.isIntl;
        String[] strArr2 = builder.permissions;
        boolean z11 = strArr2 != null && strArr2.length > 0;
        List<Pair<String, String>> list = builder.additionalGroups;
        boolean z12 = list != null && list.size() > 0;
        if (z11 || z12) {
            if (z11) {
                HashMap map = new HashMap();
                int i = 0;
                while (true) {
                    strArr = builder.permissions;
                    if (i >= strArr.length) {
                        break;
                    }
                    map.put(strArr[i], builder.permissionReasons[i]);
                    i++;
                }
                List<c> listC = this.mPermissionManager.c(strArr, false);
                this.permissions = listC;
                for (c cVar : listC) {
                    if (cVar.f10226h.size() > 0 && map.containsKey(cVar.f10224f)) {
                        cVar.f10226h.clear();
                    }
                }
                for (c cVar2 : this.permissions) {
                    ArrayList arrayList = cVar2.f10226h;
                    String str = cVar2.f10224f;
                    if (arrayList.size() > 0) {
                        ArrayList arrayList2 = cVar2.f10226h;
                        int size = arrayList2.size();
                        int i3 = 0;
                        while (i3 < size) {
                            Object obj = arrayList2.get(i3);
                            i3++;
                            b bVar = (b) obj;
                            StringBuilder sb2 = new StringBuilder("bindData: perssiongetIdentifier ");
                            String str2 = bVar.f10221f;
                            sb2.append(str2);
                            sb2.append(" | perssion name");
                            sb2.append(bVar.a());
                            Log.d("permissiontest", sb2.toString());
                            String policyModifyPerKey = PolicySdkPermissionManifestUtils.INSTANCE.getPolicyModifyPerKey(this.mContext, str2);
                            if (policyModifyPerKey.equals(str2)) {
                                policyModifyPerKey = bVar.a();
                            }
                            addGroupItem(this.contentLayout, policyModifyPerKey, (String) map.get(str2), builder.isDark);
                        }
                    } else {
                        StringBuilder sbO = androidx.activity.b.o("bindData: perssion group getIdentifier ", str, " | perssion name");
                        sbO.append(cVar2.a(this.mContext));
                        Log.d("permissiontest", sbO.toString());
                        String policyModifyPerKey2 = PolicySdkPermissionManifestUtils.INSTANCE.getPolicyModifyPerKey(this.mContext, str);
                        if (policyModifyPerKey2.equals(str)) {
                            policyModifyPerKey2 = cVar2.a(this.mContext);
                        }
                        addGroupItem(this.contentLayout, policyModifyPerKey2, (String) map.get(str), builder.isDark);
                    }
                }
            }
            if (z12) {
                for (Pair<String, String> pair : builder.additionalGroups) {
                    Log.d("permissiontest", "bindData: additionalGroups group name" + ((String) pair.first));
                    addGroupItem(this.contentLayout, (String) pair.first, (String) pair.second, builder.isDark);
                }
            }
            this.mScrollView.setOnScrollChangeListener(new k0() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionViewHandlerImpl23.1
                @Override // stepos.support.v7.widget.k0
                public void onScrollChange(View view, int i10, int i11, int i12, int i13) {
                    PolicyPermissionViewHandlerImpl23 policyPermissionViewHandlerImpl23 = PolicyPermissionViewHandlerImpl23.this;
                    policyPermissionViewHandlerImpl23.manageScrollIndicators(view, policyPermissionViewHandlerImpl23.mUpIndicator, PolicyPermissionViewHandlerImpl23.this.mDownIndicator);
                }
            });
            this.mScrollView.post(new Runnable() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionViewHandlerImpl23.2
                @Override // java.lang.Runnable
                public void run() {
                    PolicyPermissionViewHandlerImpl23 policyPermissionViewHandlerImpl23 = PolicyPermissionViewHandlerImpl23.this;
                    policyPermissionViewHandlerImpl23.manageScrollIndicators(policyPermissionViewHandlerImpl23.mScrollView, PolicyPermissionViewHandlerImpl23.this.mUpIndicator, PolicyPermissionViewHandlerImpl23.this.mDownIndicator);
                }
            });
        } else {
            this.mPermissionContainer.setVisibility(8);
        }
        boolean z13 = builder.showAlmostDenyBtn;
        CheckBox checkBox = this.almostDenyCheckBox;
        if (z13) {
            checkBox.setVisibility(0);
        } else {
            checkBox.setVisibility(8);
            z2.d dVar = (z2.d) this.mPermissionRelativeLayout.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) dVar).topMargin = 0;
            this.mPermissionRelativeLayout.setLayoutParams(dVar);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mzNestedScrollView.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.mzNestedScrollView.setLayoutParams(layoutParams);
        }
        if (!TextUtils.isEmpty(builder.reminder)) {
            this.reminderTextView.setText(builder.reminder);
            this.reminderTextView.setVisibility(0);
            return;
        }
        boolean zIsEmpty = TextUtils.isEmpty(builder.csReminder);
        TextView textView2 = this.reminderTextView;
        if (zIsEmpty) {
            textView2.setVisibility(8);
            return;
        }
        textView2.setText(builder.csReminder);
        this.reminderTextView.setVisibility(0);
        this.reminderTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override // com.stepos.policy.sdk.dialog.PolicyPermissionViewHandler
    public View createView(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.policy.sdk.R.layout.stepos_permission_dialog, viewGroup, false);
        this.mPermissionRelativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.permission_relative_layout);
        this.titleTextView = (TextView) viewInflate.findViewById(R.id.stepos_permission_dialog_title);
        this.mPermissionContainer = (LinearLayout) viewInflate.findViewById(R.id.stepos_permission_dialog_container);
        this.mUpIndicator = viewInflate.findViewById(R.id.stepos_permission_dialog_scroll_indicator_up);
        this.mScrollView = (PermissionScrollView) viewInflate.findViewById(R.id.stepos_permission_dialog_scroll_view);
        this.mzScrollBarView = (StepOSScrollBarView) viewInflate.findViewById(R.id.stepos_permission_dialog_scrollbarview_vertical);
        this.mzNestedScrollView = (StepOSNestedScrollView) viewInflate.findViewById(R.id.stepos_permission_dialog_scrollview);
        this.reminderTextView = (TextView) viewInflate.findViewById(R.id.stepos_permission_dialog_reminder);
        this.mDownIndicator = viewInflate.findViewById(R.id.stepos_permission_dialog_scroll_indicator_down);
        this.contentLayout = (LinearLayout) viewInflate.findViewById(R.id.stepos_permission_dialog_content_layout);
        this.almostDenyCheckBox = (CheckBox) viewInflate.findViewById(R.id.stepos_permission_dialog_checkbox);
        this.termsView = (TextView) viewInflate.findViewById(R.id.stepos_permission_dialog_terms);
        g.a(this.mzNestedScrollView, this.mzScrollBarView);
        return viewInflate;
    }

    @Override // com.stepos.policy.sdk.dialog.PolicyPermissionViewHandler
    public CheckBox getCheckBox() {
        return this.almostDenyCheckBox;
    }

    public Map<String, Boolean> getItemCheckedMap() {
        return this.mItemCheckedMap;
    }

    @Override // com.stepos.policy.sdk.dialog.PolicyPermissionViewHandler
    public List<c> getPermissions() {
        return this.permissions;
    }

    @Override // com.stepos.policy.sdk.dialog.PolicyPermissionViewHandler
    public TextView getTermsView() {
        return this.termsView;
    }
}
