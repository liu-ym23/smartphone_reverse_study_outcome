package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.ui.SSGridLayoutManager;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/preview/view/BaseUgcGiftDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseUgcGiftDialog extends LiveDialogFragment {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f131003o = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f131004d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f131005e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f131006f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RecyclerView f131007g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f131008h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f131009i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f131010j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f131011k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f131012l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public BaseUgcGiftAdapter<? extends RecyclerView.ViewHolder> f131013m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public DialogInterface.OnDismissListener f131014n;

    public static final class a implements LiveBottomSheetDialog.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f131015a = null;

        static {
            f131015a = new a();
        }

        public a() {
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final boolean disableDragDown() {
            return true;
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final /* synthetic */ boolean shouldInterceptSlide(int r100) {
            return true;
        }
    }

    public abstract BaseUgcGiftAdapter<? extends RecyclerView.ViewHolder> S90();

    public BaseUgcGiftDialog() {
        this.f131005e = "";
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        ViewGroup.LayoutParams r102 = null;
        if ((r101 instanceof LiveBottomSheetDialog) == true) goto L5;
        r101 = null;
    L5:
        LiveBottomSheetDialog r103 = (LiveBottomSheetDialog) r101;
        if (r103 == null) goto L8;
        View r104 = r103.getBottomSheetView();
    L9:
        if (r104 == null) goto L12;
        r102 = r104.getLayoutParams();
    L12:
        if (r102 == null) goto L14;
        r102.height = -1;
    L14:
        if (r104 == null) goto L16;
        r104.setLayoutParams(r102);
    L16:
        Dialog r105 = getDialog();
        if (r105 == null) goto L23;
        Window r106 = r105.getWindow();
        if (r106 == null) goto L21;
        r106.setLayout(-1, -2);
        WindowManager.LayoutParams r107 = r106.getAttributes();
        r107.width = s1.y();
        r107.height = s1.w() - s1.A();
        r106.setAttributes(r107);
        r106.setGravity(80);
    L21:
        r105.setCanceledOnTouchOutside(true);
        return;
    L23:
        return;
    L8:
        r104 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_interact_gift_dialog);
        super.setBottomSheetSlideProcessor(a.f131015a);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        RecyclerView r102 = (RecyclerView) r100.findViewById(R.id.gift_list_rv);
        r102.setItemViewCacheSize(12);
        View r103 = null;
        r102.setItemAnimator(null);
        r102.setLayoutManager(new SSGridLayoutManager(r102.getContext(), 4, 1));
        r102.setClipChildren(false);
        r102.setClipToPadding(false);
        r102.addItemDecoration(new BaseUgcGiftDialog$create$1$1());
        this.f131007g = r102;
        BaseUgcGiftAdapter<? extends RecyclerView.ViewHolder> r104 = S90();
        this.f131013m = r104;
        RecyclerView r105 = this.f131007g;
        if (r105 == null) goto L5;
        r105.setAdapter(r104);
    L5:
        View r106 = r100.findViewById(R.id.camera_container);
        if (r106 != null) goto L8;
    L11:
        this.f131011k = r103;
        this.f131012l = r100.findViewById(R.id.camera_view);
        View r107 = this.f131011k;
        if (r107 == null) goto L15;
        r107.setOnClickListener(new com.bytedance.android.livesdk.gift.platform.core.preview.view.a(this));
        return;
    L15:
        return;
    L8:
        if (this.f131006f == null) goto L10;
        r106.setVisibility(0);
    L10:
        Unit r108 = Unit.INSTANCE;
        r103 = r106;
        goto L11
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Dialog r103 = getDialog();
        if (r103 == null) goto L8;
        Window r104 = r103.getWindow();
        if (r104 == null) goto L8;
        r104.setSoftInputMode(48);
    L8:
        return r100.inflate(R.layout.ttlive_interact_gift_manager_dialog, r101, false);
    }
}
