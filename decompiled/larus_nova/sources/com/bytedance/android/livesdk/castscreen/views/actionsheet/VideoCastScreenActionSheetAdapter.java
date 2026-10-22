package com.bytedance.android.livesdk.castscreen.views.actionsheet;

import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.resolution.AudienceVideoResolutionManager;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.crash.d;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/views/actionsheet/VideoCastScreenActionSheetAdapter;", "Lcom/bytedance/android/livesdk/castscreen/views/actionsheet/CastScreenActionSheet$ActionSheetAdapter;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoCastScreenActionSheetAdapter extends CastScreenActionSheet.ActionSheetAdapter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CastScreenActionSheet f104775b;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoCastScreenActionSheetAdapter f104776a;

        public b(VideoCastScreenActionSheetAdapter r100, CastScreenActionSheet.a r101) {
            this.f104776a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f104776a.f104775b.getClass();
            Dialog r101 = this.f104776a.f104775b.getDialog();
            if (r101 == null) goto L21;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r101);
            return;
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L14:
            e = move-exception;
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r103 == null) goto L18;
            d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
            goto L18
        L7:
            if (Looper.myLooper() == r102.getLooper()) goto L9;
            r102.post(DialogLancet.createDismissRunnable(r101));
            return;
        }
    }

    static {
    }

    public VideoCastScreenActionSheetAdapter(CastScreenActionSheet r100) {
        Intrinsics.checkNotNullParameter(r100, "actionSheet");
        super(r100);
        this.f104775b = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        ((CastScreenActionSheet.a) ListProtector.get(this.f104775b.f104760e, r100)).getClass();
        int r101 = AudienceVideoResolutionManager.f110411a;
        ALogger.d("audience_resolution", "is HDR resolution:null");
        if (Intrinsics.areEqual(null, "hdr") == false) goto L5;
    L8:
        return 1;
    L5:
        if (Intrinsics.areEqual(null, AudienceVideoResolutionManager.f110434x.get("hdr")) == true) goto L8;
        return 0;
    }

    @Override // com.bytedance.android.livesdk.castscreen.views.actionsheet.CastScreenActionSheet.ActionSheetAdapter
    public final int y2(boolean r100) {
        if (r100 == false) goto L5;
        return (int) s1.e(60.0f);
    L5:
        return super.y2(false);
    }

    @Override // com.bytedance.android.livesdk.castscreen.views.actionsheet.CastScreenActionSheet.ActionSheetAdapter
    public final CastScreenActionSheet.ActionSheetItemViewHolder A2(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "viewGroup");
        if (r101 != 1) goto L12;
        boolean r102 = false;
        View r103 = LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_item_vs_hdr_resolution, r100, false);
        if (this.f104775b.isVertical() == false) goto L7;
    L9:
        r102 = true;
    L13:
        return new HDRCastScreenViewHolder(r103, true ^ r102);
    L7:
        if (PadConfigUtils.c() == false) goto L13;
        PadConfigUtils.c();
        goto L9
    L12:
        return super.A2(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.castscreen.views.actionsheet.CastScreenActionSheet.ActionSheetAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        z2((CastScreenActionSheet.ActionSheetItemViewHolder) r100, r101);
    }

    @Override // com.bytedance.android.livesdk.castscreen.views.actionsheet.CastScreenActionSheet.ActionSheetAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return A2(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.castscreen.views.actionsheet.CastScreenActionSheet.ActionSheetAdapter
    public final void z2(CastScreenActionSheet.ActionSheetItemViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "viewHolder");
        View r102 = null;
        if ((r100 instanceof HDRCastScreenViewHolder) == false) goto L16;
        CastScreenActionSheet.a r103 = (CastScreenActionSheet.a) ListProtector.get(this.f104775b.f104760e, r101);
        r103.getClass();
        r100.f104770a.setOnClickListener(new b(this, r103));
        HDRCastScreenViewHolder r104 = (HDRCastScreenViewHolder) r100;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        if (r104.f104774e == false) goto L7;
        r104.f104770a.setBackgroundDrawable(null);
    L7:
        TextView r105 = r104.f104771b;
        if (r105 == null) goto L10;
        r105.setTextColor(ColorProtector.parseColor("#80FFFFFF"));
    L10:
        View r106 = r104.f104772c;
        if (r106 == null) goto L13;
        r106.setBackground(s1.m(R.drawable.ttlive_bg_vs_hdr_limited_time_tip));
    L13:
        View r107 = r104.f104773d;
        if (r107 == null) goto L24;
        r107.setBackground(s1.m(R.drawable.ttlive_ic_vs_hdr_resolution));
        return;
    L24:
        return;
    L16:
        super.z2(r100, r101);
        View r108 = r100.f104770a;
        if ((r108 instanceof TextView) == false) goto L20;
        r102 = r108;
    L20:
        TextView r109 = (TextView) r102;
        if (r109 == null) goto L26;
        r109.setTypeface(Typeface.DEFAULT_BOLD);
        return;
    }
}
