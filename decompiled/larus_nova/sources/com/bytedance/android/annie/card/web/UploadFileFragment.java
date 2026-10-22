package com.bytedance.android.annie.card.web;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import bytedance.io.BdMediaFileSystem;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/annie/card/web/UploadFileFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "annie_release"}, k = 1, mv = {1, 4, 3})
public final class UploadFileFragment extends Fragment {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f39150i = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f39151d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.annie.card.web.a f39152e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super Uri[], Unit> f39153f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f39154g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f39155h;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f39156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ UploadFileFragment f39157b;

        public b(FragmentActivity r100, UploadFileFragment r101) {
            this.f39156a = r100;
            this.f39157b = r101;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r100) {
            com.bytedance.android.annie.util.c.b(this.f39156a, R.string.hybrid_web_upload_cancel);
            UploadFileFragment r101 = this.f39157b;
            int r102 = UploadFileFragment.f39150i;
            r101.T90(null);
        }
    }

    public static final class c implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UploadFileFragment f39158a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Intent f39159b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f39160c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f39161d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Intent f39162e;

        public c(UploadFileFragment r100, Intent r101, FragmentActivity r102, String r103, Intent r104) {
            this.f39158a = r100;
            this.f39159b = r101;
            this.f39160c = r102;
            this.f39161d = r103;
            this.f39162e = r104;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            if (r101 != (-2)) goto L5;
            UploadFileFragment r102 = this.f39158a;
            Intent r103 = this.f39159b;
            int r104 = UploadFileFragment.f39150i;
            r102.V90(r103);
        L12:
            r100.dismiss();
            return;
        L5:
            if (r101 != (-1)) goto L12;
            UploadFileFragment r105 = this.f39158a;
            FragmentActivity r106 = this.f39160c;
            String r107 = this.f39161d;
            Intent r108 = this.f39162e;
            int r109 = UploadFileFragment.f39150i;
            r105.getClass();
            if (com.bytedance.android.annie.bridge.method.permission.c.a(r106, r107) == false) goto L10;
            r105.V90(r108);
            goto L12
        L10:
            r105.f39152e = new com.bytedance.android.annie.card.web.b(r105, r108, r106);
            r105.requestPermissions(new String[]{r107}, 1024);
            goto L12
        }
    }

    static {
    }

    public UploadFileFragment() {
    }

    public final void T90(Uri[] r100) {
        Function1<? super Uri[], Unit> r101 = this.f39153f;
        if (r101 == null) goto L5;
        r101.invoke(r100);
        this.f39153f = null;
    L5:
        this.f39154g = null;
        this.f39155h = false;
    }

    public final void V90(Intent r100) {
        startActivityForResult(r100, 2048);     // Catch: ActivityNotFoundException -> L5
        return;
    L5:
        e = move-exception;
        FragmentActivity r101 = getActivity();
        if (r101 == null) goto L9;
        com.bytedance.android.annie.util.c.b(r101, R.string.hybrid_web_upload_failed);
    L9:
        this.f39155h = true;
        T90(null);
        e.printStackTrace();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r110, int r111, Intent r112) {
        if (r110 == 2048) goto L5;
        return;
    L5:
        if (r111 == 0) goto L7;
    L10:
        PolarisFileInputStreamWrapper r100 = null;
        if (r112 == null) goto L27;
        if (r111 != (-1)) goto L27;
        ClipData r101 = r112.getClipData();
        if (r101 == null) goto L24;
        ArrayList r102 = new ArrayList();
        int r103 = r101.getItemCount();
        int r104 = 0;
    L17:
        if (r104 >= r103) goto L19;
        r102.add(r101.getItemAt(r104).getUri());
        r104 = r104 + 1;
        goto L17
    L19:
        Object[] r105 = r102.toArray(new Uri[0]);
        if (r105 == null) goto L23;
        Uri[] r106 = (Uri[]) r105;
    L28:
        if (r106 != null) goto L71;
        if (r112 != null) goto L71;
        if (r111 != (-1)) goto L71;
        String r113 = this.f39154g;
        if (r113 == null) goto L71;
        PolarisFileWrapper r114 = new PolarisFileWrapper(r113);
        if (r114.exists() == false) goto L71;
        r106 = new Uri[]{Uri.fromFile(r114)};
        Context r115 = this.f39151d;
        if (r115 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
        r115 = null;
    L38:
        String r107 = this.f39154g;
        Intrinsics.checkNotNull(r107);
        String r116 = r114.getName();
        PolarisFileWrapper r108 = new PolarisFileWrapper(r116);
        if (StringsKt.contains$default(r116, Environment.DIRECTORY_DCIM, false, 2, null) == false) goto L46;
        int r117 = StringsKt.indexOf$default(r116, Environment.DIRECTORY_DCIM, 0, false, 6, null);
        if (r116 == null) goto L44;
        String r118 = r116.substring(r117);
    L49:
        PolarisFileWrapper r119 = new PolarisFileWrapper(r118);
        String r120 = r119.getName();
        File r121 = r119.getParentFile();
        if (r121 == null) goto L52;
        String r122 = r121.getPath();
    L53:
        if (r122 != null) goto L73;
        r122 = "";
    L73:
        Uri r123 = BdMediaFileSystem.createImageUri(r115, r120, "image/*", r122);     // Catch: Exception -> L57
    L58:
        if (r123 == null) goto L71;
        OutputStream r124 = ContentResolverWrapper.openOutputStream(r115.getContentResolver(), r123);     // Catch: Exception -> L62
    L63:
        if (r124 == null) goto L71;
        r100 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r107));     // Catch: Exception -> L67
    L68:
        if (r100 == null) goto L71;
        com.bytedance.android.annie.util.d.b(r100, r124);
    L62:
        r124 = null;
    L57:
        r123 = null;
        goto L58
    L52:
        r122 = null;
        goto L53
    L44:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L46:
        if (r108.isAbsolute() == true) goto L48;
        r118 = Environment.DIRECTORY_DCIM + File.separator + r116;
        goto L49
    L48:
        StringBuilder r125 = new StringBuilder();
        r125.append(Environment.DIRECTORY_DCIM);
        String r126 = File.separator;
        r125.append(r126);
        r125.append("Camera");
        r125.append(r126);
        r125.append(r108.getName());
        r118 = r125.toString();
    L71:
        T90(r106);
        return;
    L23:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L24:
        Uri r109 = r112.getData();
        if (r109 == null) goto L27;
        r106 = new Uri[]{r109};
    L27:
        r106 = null;
        goto L28
    L7:
        if (this.f39155h == false) goto L10;
        this.f39155h = false;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onRequestPermissionsResult(int r100, String[] r101, int[] r102) {
        Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
        Intrinsics.checkNotNullParameter(r102, "grantResults");
        if (r100 == 1024) goto L5;
        return;
    L5:
        if (r102.length != 0) goto L7;
        boolean r103 = true;
    L9:
        if ((!r103) == true) goto L11;
    L15:
        com.bytedance.android.annie.card.web.a r104 = this.f39152e;
        if (r104 == null) goto L22;
        r104.onPermissionDenied();
        return;
    L22:
        return;
    L11:
        if (r102[0] != 0) goto L15;
        com.bytedance.android.annie.card.web.a r105 = this.f39152e;
        if (r105 == null) goto L20;
        r105.onPermissionGranted();
        return;
    L20:
        return;
    L7:
        r103 = false;
        goto L9
    }

    public final Intent S90(boolean r100, boolean r101, boolean r102, boolean r103) {
        Intent r104 = new Intent("android.intent.action.GET_CONTENT");
        r104.addCategory("android.intent.category.OPENABLE");
        ArrayList r105 = new ArrayList();
        if (r100 == false) goto L5;
        String r106 = "image/*";
        r105.add("image/*");
    L6:
        String r107 = "*/*";
        boolean r108 = true;
        if (r101 == true) goto L9;
    L17:
        if (r102 == true) goto L19;
    L26:
        r104.setType(r106);
        Object[] r109 = r105.toArray(new String[0]);
        if (r109 == null) goto L31;
        r104.putExtra("android.intent.extra.MIME_TYPES", (String[]) r109);
        r104.putExtra("android.intent.extra.ALLOW_MULTIPLE", r103);
        return r104;
    L31:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L19:
        if (r106.length() == 0) goto L23;
        r108 = false;
    L23:
        if (r108 == false) goto L25;
        r107 = "audio/*";
    L25:
        r105.add("audio/*");
        r106 = r107;
        goto L26
    L9:
        if (r106.length() != 0) goto L11;
        boolean r110 = true;
    L13:
        if (r110 == false) goto L15;
        r106 = "video/*";
    L16:
        r105.add("video/*");
        goto L17
    L15:
        r106 = "*/*";
        goto L16
    L11:
        r110 = false;
        goto L13
    L5:
        r106 = "";
        goto L6
    }

    public final void U90(String r110, int r111, Intent r112, int r113, Intent r114) {
        FragmentActivity r100 = getActivity();
        if (r100 == null) goto L5;
        AlertDialog.Builder r101 = new AlertDialog.Builder(r100);
        r101.setTitle(R.string.hybrid_web_upload_title);
        r101.setMessage(R.string.hybrid_web_upload_msg);
        c r102 = new c(this, r114, r100, r110, r112);
        r101.setPositiveButton(r111, r102);
        r101.setNegativeButton(r113, r102);
        r101.setOnCancelListener(new b(r100, this));
        AlertDialog r115 = r101.show();
    L6:
        if (r115 != null) goto L9;
        T90(null);
        return;
    L9:
        return;
    L5:
        r115 = null;
        goto L6
    }
}
