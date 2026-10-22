package com.stepos.policy.sdk.dialog;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.stepos.common.R$dimen;
import com.stepos.common.scrollbarview.StepOSScrollBarView;
import com.stepos.common.scrollview.StepOSNestedScrollView;
import com.stepos.common.widget.Switch;
import com.stepos.policy.sdk.dialog.PolicyPermissionDialogView;
import com.stepos.policy.sdk.util.PolicyDialogScrollHelper;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import stepos.support.v7.appcompat.R$color;
import stepos.support.v7.appcompat.R$id;
import stepos.support.v7.appcompat.R$layout;
import stepos.support.v7.permission.c;
import stepos.support.v7.permission.d;
import stepos.support.v7.permission.e;
import stepos.support.v7.widget.PermissionScrollView;

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
    private final e mPermissionManager;
    private RelativeLayout mPermissionRelativeLayout;
    private PermissionScrollView mScrollView;
    private final int mTitleColor;
    private View mUpIndicator;
    private StepOSNestedScrollView mzNestedScrollView;
    private StepOSScrollBarView mzScrollBarView;
    private List<d> permissions;
    private TextView reminderTextView;
    private TextView termsView;
    private TextView titleTextView;

    public PolicyPermissionViewHandlerImpl23(Context context) {
        this.mContext = context;
        this.mTitleColor = context.getResources().getColor(R$color.stepos_alert_dialog_title_color_dark);
        this.mItemTitleColor = context.getResources().getColor(R$color.stepos_permission_dialog_item_title_dark);
        this.mItemSummaryColor = context.getResources().getColor(R$color.stepos_permission_dialog_item_summary_dark);
        this.mPermissionManager = e.b(context);
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    private void addGroupItem(ViewGroup viewGroup, String str, String str2, boolean z10) {
        if (this.isIntl) {
            addGroupItemIntl(viewGroup, str, str2, z10);
            return;
        }
        if (viewGroup.getChildCount() != 0) {
            viewGroup.addView(new Space(this.mContext), new LinearLayout.LayoutParams(-1, Hc.a.a(this.mContext, 22.0d)));
        }
        View viewInflate = this.mLayoutInflater.inflate(R$layout.stepos_permission_dialog_item, viewGroup, false);
        TextView textView = (TextView) viewInflate.findViewById(R$id.stepos_permission_dialog_item_title);
        TextView textView2 = (TextView) viewInflate.findViewById(R$id.stepos_permission_dialog_item_summary);
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

    private void addGroupItemIntl(ViewGroup viewGroup, final String str, String str2, boolean z10) {
        View viewInflate = this.mLayoutInflater.inflate(R$layout.stepos_permission_dialog_item_intl, viewGroup, false);
        TextView textView = (TextView) viewInflate.findViewById(R$id.switch_title);
        TextView textView2 = (TextView) viewInflate.findViewById(R$id.switch_info);
        final Switch r32 = (Switch) viewInflate.findViewById(R$id.switch1);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.policy.sdk.dialog.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r32.toggle();
            }
        });
        r32.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.stepos.policy.sdk.dialog.b
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
                this.f30596a.mItemCheckedMap.put(str, Boolean.valueOf(z11));
            }
        });
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
        return (getTextWidth(textView, textView.getText().toString()) + (textView.getPaddingLeft() + textView.getPaddingRight())) + (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin) <= this.mContext.getResources().getDimensionPixelOffset(R$dimen.stepos_alert_dialog_width);
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
    public void bindData(PolicyPermissionDialogView.Builder builder) throws PackageManager.NameNotFoundException {
        String[] strArr;
        if (builder.mShowTitle) {
            this.titleTextView.setText(builder.appName);
            if (isTextViewOneLine(this.titleTextView)) {
                this.titleTextView.setGravity(17);
            }
        } else {
            this.titleTextView.setVisibility(8);
        }
        if (builder.isDark) {
            this.titleTextView.setTextColor(this.mTitleColor);
        }
        this.isIntl = builder.isIntl;
        String[] strArr2 = builder.permissions;
        boolean z10 = strArr2 != null && strArr2.length > 0;
        List<Pair<String, String>> list = builder.additionalGroups;
        boolean z11 = list != null && list.size() > 0;
        if (z10 || z11) {
            if (z10) {
                HashMap map = new HashMap();
                int i10 = 0;
                while (true) {
                    strArr = builder.permissions;
                    if (i10 >= strArr.length) {
                        break;
                    }
                    map.put(strArr[i10], builder.permissionReasons[i10]);
                    i10++;
                }
                List<d> listE = this.mPermissionManager.e(strArr, false);
                this.permissions = listE;
                for (d dVar : listE) {
                    if (dVar.i().size() > 0 && map.containsKey(dVar.e())) {
                        dVar.i().clear();
                    }
                }
                for (d dVar2 : this.permissions) {
                    if (dVar2.i().size() > 0) {
                        for (c cVar : dVar2.i()) {
                            Log.d("permissiontest", "bindData: perssiongetIdentifier " + cVar.c() + " | perssion name" + cVar.b(this.mContext));
                            String policyModifyPerKey = PolicySdkPermissionManifestUtils.INSTANCE.getPolicyModifyPerKey(this.mContext, cVar.c());
                            if (policyModifyPerKey.equals(cVar.c())) {
                                policyModifyPerKey = cVar.b(this.mContext);
                            }
                            addGroupItem(this.contentLayout, policyModifyPerKey, (String) map.get(cVar.c()), builder.isDark);
                        }
                    } else {
                        Log.d("permissiontest", "bindData: perssion group getIdentifier " + dVar2.e() + " | perssion name" + dVar2.c(this.mContext));
                        String policyModifyPerKey2 = PolicySdkPermissionManifestUtils.INSTANCE.getPolicyModifyPerKey(this.mContext, dVar2.e());
                        if (policyModifyPerKey2.equals(dVar2.e())) {
                            policyModifyPerKey2 = dVar2.c(this.mContext);
                        }
                        addGroupItem(this.contentLayout, policyModifyPerKey2, (String) map.get(dVar2.e()), builder.isDark);
                    }
                }
            }
            if (z11) {
                for (Pair<String, String> pair : builder.additionalGroups) {
                    Log.d("permissiontest", "bindData: additionalGroups group name" + ((String) pair.first));
                    addGroupItem(this.contentLayout, (String) pair.first, (String) pair.second, builder.isDark);
                }
            }
            this.mScrollView.setOnScrollChangeListener(new PermissionScrollView.a() { // from class: com.stepos.policy.sdk.dialog.PolicyPermissionViewHandlerImpl23.1
                @Override // stepos.support.v7.widget.PermissionScrollView.a
                public void onScrollChange(View view, int i11, int i12, int i13, int i14) {
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
        if (builder.showAlmostDenyBtn) {
            this.almostDenyCheckBox.setVisibility(0);
        } else {
            this.almostDenyCheckBox.setVisibility(8);
            ConstraintLayout.b bVar = (ConstraintLayout.b) this.mPermissionRelativeLayout.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = 0;
            this.mPermissionRelativeLayout.setLayoutParams(bVar);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mzNestedScrollView.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.mzNestedScrollView.setLayoutParams(layoutParams);
        }
        if (!TextUtils.isEmpty(builder.reminder)) {
            this.reminderTextView.setText(builder.reminder);
            this.reminderTextView.setVisibility(0);
        } else if (TextUtils.isEmpty(builder.csReminder)) {
            this.reminderTextView.setVisibility(8);
        } else {
            this.reminderTextView.setText(builder.csReminder);
            this.reminderTextView.setVisibility(0);
            this.reminderTextView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        PolicyDialogScrollHelper.limitScrollView(this.mzNestedScrollView, this.titleTextView);
    }

    @Override // com.stepos.policy.sdk.dialog.PolicyPermissionViewHandler
    public View createView(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.mContext).inflate(com.stepos.policy.sdk.R$layout.stepos_permission_dialog, viewGroup, false);
        this.mPermissionRelativeLayout = (RelativeLayout) viewInflate.findViewById(R$id.permission_relative_layout);
        this.titleTextView = (TextView) viewInflate.findViewById(R$id.stepos_permission_dialog_title);
        this.mPermissionContainer = (LinearLayout) viewInflate.findViewById(R$id.stepos_permission_dialog_container);
        this.mUpIndicator = viewInflate.findViewById(R$id.stepos_permission_dialog_scroll_indicator_up);
        this.mScrollView = (PermissionScrollView) viewInflate.findViewById(R$id.stepos_permission_dialog_scroll_view);
        this.mzScrollBarView = (StepOSScrollBarView) viewInflate.findViewById(R$id.stepos_permission_dialog_scrollbarview_vertical);
        this.mzNestedScrollView = (StepOSNestedScrollView) viewInflate.findViewById(R$id.stepos_permission_dialog_scrollview);
        this.reminderTextView = (TextView) viewInflate.findViewById(R$id.stepos_permission_dialog_reminder);
        this.mDownIndicator = viewInflate.findViewById(R$id.stepos_permission_dialog_scroll_indicator_down);
        this.contentLayout = (LinearLayout) viewInflate.findViewById(R$id.stepos_permission_dialog_content_layout);
        this.almostDenyCheckBox = (CheckBox) viewInflate.findViewById(R$id.stepos_permission_dialog_checkbox);
        this.termsView = (TextView) viewInflate.findViewById(R$id.stepos_permission_dialog_terms);
        com.stepos.common.scrollbarview.d.b(this.mzNestedScrollView, this.mzScrollBarView);
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
    public List<d> getPermissions() {
        return this.permissions;
    }

    @Override // com.stepos.policy.sdk.dialog.PolicyPermissionViewHandler
    public TextView getTermsView() {
        return this.termsView;
    }
}
