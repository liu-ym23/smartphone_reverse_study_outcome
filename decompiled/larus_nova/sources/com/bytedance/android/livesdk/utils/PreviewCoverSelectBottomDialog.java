package com.bytedance.android.livesdk.utils;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.larus.nova.R;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/utils/PreviewCoverSelectBottomDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewCoverSelectBottomDialog extends CommonStandardBottomDialog {

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PreviewCoverSelectBottomDialog f158775a;

        public a(PreviewCoverSelectBottomDialog r100) {
            this.f158775a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f158775a.getClass();
            throw null;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PreviewCoverSelectBottomDialog f158776a;

        public b(PreviewCoverSelectBottomDialog r100) {
            this.f158776a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f158776a.getClass();
            throw null;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PreviewCoverSelectBottomDialog f158777a;

        public c(PreviewCoverSelectBottomDialog r100) {
            this.f158777a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f158777a.getClass();
            throw null;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PreviewCoverSelectBottomDialog f158778a;

        public d(PreviewCoverSelectBottomDialog r100) {
            this.f158778a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f158778a.getClass();
            throw null;
        }
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_dialog_media_upload_options;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        r101.setDimAmount(0.0f);
    L5:
        TextView r102 = (TextView) findViewById(R.id.tv_smart_generate);
        if (r102 == null) goto L8;
        r102.setOnClickListener(new a(this));
    L8:
        TextView r103 = (TextView) findViewById(R.id.tv_camera_upload);
        if (r103 == null) goto L11;
        r103.setOnClickListener(new b(this));
    L11:
        TextView r104 = (TextView) findViewById(R.id.tv_album_upload);
        if (r104 == null) goto L14;
        r104.setOnClickListener(new c(this));
    L14:
        TextView r105 = (TextView) findViewById(R.id.tv_cancel);
        if (r105 == null) goto L18;
        r105.setOnClickListener(new d(this));
        return;
    }
}
