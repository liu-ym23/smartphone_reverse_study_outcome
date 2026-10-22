package com.bytedance.android.livesdk.gift.fastgift;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/fastgift/PopupGiftDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PopupGiftDialogFragment extends LiveDialogFragment {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f126111f = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f126112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FastGiftViewModel f126113e;

    public static final class a {
    }

    public static final class b implements LiveBottomSheetDialog.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f126114a = null;

        static {
            f126114a = new b();
        }

        public b() {
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final boolean disableDragDown() {
            return false;
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final /* synthetic */ boolean shouldInterceptSlide(int r100) {
            return true;
        }
    }

    static {
    }

    public PopupGiftDialogFragment() {
        this.f126112d = new LinkedHashMap();
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.f126112d).clear();
    }

    public final View S90(int r100) {
        if (this.f126112d != null) goto L5;
        this.f126112d = new LinkedHashMap();
    L5:
        View r101 = this.f126112d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f126112d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L8;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L9;
        r102.setGravity(80);
        r102.clearFlags(1024);
        r102.setAttributes(r102.getAttributes());
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_gift_dialog);
        setBottomSheetSlideProcessor(b.f126114a);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        r101.requestWindowFeature(1);
        return r101;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Ref.IntRef r102 = new Ref.IntRef();
        r102.element = 0;
        GiftManagerKt.f130762z.getClass();
        com.bytedance.android.livesdk.gift.platform.core.model.e0 r103 = GiftManagerKt.x();
        if (r103 != null) goto L5;
    L39:
        View r104 = S90(R.id.close);
        if (r104 == null) goto L42;
        r104.setOnClickListener(new e0(this));
    L42:
        View r105 = S90(R.id.close_area);
        if (r105 == null) goto L46;
        r105.setOnClickListener(new f0(this));
        return;
    L46:
        return;
    L5:
        if (r103.e() != null) goto L7;
    L15:
        boolean r106 = false;
    L16:
        if (r106 == true) goto L19;
        r103 = null;
    L19:
        if (r103 == null) goto L39;
        FastGiftViewModel r107 = this.f126113e;
        if (r107 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L24:
        if (r107.getRechargedState() != 1) goto L26;
        com.bytedance.android.livesdk.gift.platform.core.model.z r108 = (com.bytedance.android.livesdk.gift.platform.core.model.z) ListProtector.get(r103.b(), 0);
    L27:
        c0 r109 = new c0(this, r102);
        HSImageView r110 = (HSImageView) S90(R.id.pop_up_image);
        if (r110 == null) goto L30;
        r110.setController(Fresco.newDraweeControllerBuilder().setUri((String) ListProtector.get(r108.b().getUrls(), 0)).setAutoPlayAnimations(false).setControllerListener(r109).build());
    L30:
        HSImageView r111 = (HSImageView) S90(R.id.pop_up_button_image);
        if (r111 == null) goto L33;
        r111.setController(Fresco.newDraweeControllerBuilder().setUri((String) ListProtector.get(r108.a().getUrls(), 0)).setAutoPlayAnimations(false).setControllerListener(r109).build());
    L33:
        TextView r112 = (TextView) S90(R.id.display_text);
        if (r112 == null) goto L36;
        r112.setText(((ur2.a) vh6.c.b(ur2.a.class)).Lf(r108.c(), ""));
    L36:
        HSImageView r113 = (HSImageView) S90(R.id.pop_up_button_image);
        if (r113 == null) goto L39;
        r113.setOnClickListener(new d0(r108, this));
        goto L39
    L26:
        r108 = (com.bytedance.android.livesdk.gift.platform.core.model.z) ListProtector.get(r103.b(), 1);
        goto L27
    L7:
        if (r103.c() == null) goto L15;
        if (r103.d() == null) goto L15;
        if (r103.b() == null) goto L15;
        if (r103.b().size() != 2) goto L15;
        r106 = true;
        goto L16
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_dialog_exclusive_gift_guide, r101, false);
    }
}
