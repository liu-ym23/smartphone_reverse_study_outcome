package com.bytedanceos.common.ui.recycler.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.network.ads.AdsReportManager;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.bytedanceos.common.toolbox.q;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.text.OTextView;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class FirstRecommendAppsBinder extends com.drakeet.multitype.b {
    private static final int RADIUS = 28;
    private List<AppInfo> mAppInfoList;
    private ItemClickListener mItemClickListener;

    public interface ItemClickListener {
        void onClick();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private AppInfo mEntity;
        private NetworkImageView mIvLogo;
        private OCheckBox mIvSelect;
        private OTextView mTvName;
        final /* synthetic */ FirstRecommendAppsBinder this$0;

        public ViewHolder(FirstRecommendAppsBinder r10, View r11) {
            this.this$0 = r10;
            super(r11);
            this.mIvLogo = (NetworkImageView) r11.findViewById(R$id.iv_logo);
            this.mTvName = (OTextView) r11.findViewById(R$id.tv_name);
            OCheckBox r12 = (OCheckBox) r11.findViewById(R$id.iv_select);
            this.mIvSelect = r12;
            r12.setOnCheckedChangeListener(new a(this));
            r11.setOnClickListener(new b(this));
        }

        public static /* synthetic */ void a(ViewHolder r10, OCheckBox r11, boolean r12) {
            r10.lambda$new$0(r11, r12);
        }

        public static /* synthetic */ NetworkImageView access$000(ViewHolder r10) {
            return r10.mIvLogo;
        }

        public static /* synthetic */ OTextView access$100(ViewHolder r10) {
            return r10.mTvName;
        }

        public static /* synthetic */ OCheckBox access$200(ViewHolder r10) {
            return r10.mIvSelect;
        }

        public static /* synthetic */ AppInfo access$302(ViewHolder r10, AppInfo r11) {
            r10.mEntity = r11;
            return r11;
        }

        public static /* synthetic */ void b(ViewHolder r10, View r11) {
            r10.lambda$new$1(r11);
        }

        private /* synthetic */ void lambda$new$0(OCheckBox r10, boolean r11) {
            OCheckBox r12 = this.mIvSelect;
            if (r11 == false) goto L5;
            int r13 = 0;
        L6:
            r12.setVisibility(r13);
            AppInfo r14 = this.mEntity;
            if (r14 == null) goto L16;
            r14.default_check = r11 ? 1 : 0;
            if (r11 == false) goto L11;
            FirstRecommendAppsBinder.access$400(this.this$0).add(this.mEntity);
        L13:
            if (FirstRecommendAppsBinder.access$500(this.this$0) == null) goto L17;
            FirstRecommendAppsBinder.access$500(this.this$0).onClick();
            return;
        L17:
            return;
        L11:
            FirstRecommendAppsBinder.access$400(this.this$0).remove(this.mEntity);
            goto L13
        L16:
            return;
        L5:
            r13 = 8;
            goto L6
        }

        private /* synthetic */ void lambda$new$1(View r10) {
            this.mIvSelect.toggle();
        }
    }

    public FirstRecommendAppsBinder(List<AppInfo> r10) {
        this.mAppInfoList = r10;
    }

    public static /* synthetic */ List access$400(FirstRecommendAppsBinder r10) {
        return r10.mAppInfoList;
    }

    public static /* synthetic */ ItemClickListener access$500(FirstRecommendAppsBinder r10) {
        return r10.mItemClickListener;
    }

    @Override // com.drakeet.multitype.c
    public /* bridge */ /* synthetic */ void onBindViewHolder(@NonNull RecyclerView.ViewHolder r10, @NonNull Object r11) {
        onBindViewHolder((ViewHolder) r10, (AppInfo) r11);
    }

    @Override // com.drakeet.multitype.b
    @NonNull
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(@NonNull LayoutInflater r10, @NonNull ViewGroup r11) {
        return onCreateViewHolder(r10, r11);
    }

    public void setItemClickListener(ItemClickListener r10) {
        this.mItemClickListener = r10;
    }

    public void onBindViewHolder(@NonNull ViewHolder r10, @NonNull AppInfo r11) {
        ViewHolder.access$000(r10).e(r11.appIcon, q.a(28));
        NetworkImageView r12 = ViewHolder.access$000(r10);
        int r13 = R$drawable.oui_default_app_icon;
        r12.setErrorImageResId(r13);
        ViewHolder.access$000(r10).setDefaultImageResId(r13);
        ViewHolder.access$100(r10).setText(r11.appName);
        OCheckBox r14 = ViewHolder.access$200(r10);
        int r15 = 0;
        if (r11.default_check != 1) goto L5;
        boolean r16 = true;
    L6:
        r14.setChecked(r16);
        OCheckBox r17 = ViewHolder.access$200(r10);
        if (r11.default_check == 1) goto L10;
        r15 = 8;
    L10:
        r17.setVisibility(r15);
        ViewHolder.access$302(r10, r11);
        AdsReportManager.h().k(r11);
        return;
    L5:
        r16 = false;
        goto L6
    }

    @Override // com.drakeet.multitype.b
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull LayoutInflater r10, @NonNull ViewGroup r11) {
        return new ViewHolder(this, r10.inflate(R$layout.item_first_recommend_apps, r11, false));
    }
}
