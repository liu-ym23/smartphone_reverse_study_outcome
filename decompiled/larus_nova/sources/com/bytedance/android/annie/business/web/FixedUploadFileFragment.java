package com.bytedance.android.annie.business.web;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import bytedance.io.BdMediaFileSystem;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/annie/business/web/FixedUploadFileFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "annie-mix-glue_release"}, k = 1, mv = {1, 4, 3})
public final class FixedUploadFileFragment extends Fragment {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f39067i = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f39068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f39069e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super Uri[], Unit> f39070f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f39071g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f39072h;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f39073a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FixedUploadFileFragment f39074b;

        public b(FragmentActivity r100, FixedUploadFileFragment r101) {
            this.f39073a = r100;
            this.f39074b = r101;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r100) {
            com.bytedance.android.annie.util.c.b(this.f39073a, R.string.hybrid_web_upload_cancel);
            FixedUploadFileFragment r101 = this.f39074b;
            int r102 = FixedUploadFileFragment.f39067i;
            r101.T90(null);
        }
    }

    public static final class c implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FixedUploadFileFragment f39075a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Intent f39076b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f39077c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f39078d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Intent f39079e;

        public c(FixedUploadFileFragment r100, Intent r101, FragmentActivity r102, String r103, Intent r104) {
            this.f39075a = r100;
            this.f39076b = r101;
            this.f39077c = r102;
            this.f39078d = r103;
            this.f39079e = r104;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            if (r101 != (-2)) goto L5;
            FixedUploadFileFragment r102 = this.f39075a;
            Intent r103 = this.f39076b;
            int r104 = FixedUploadFileFragment.f39067i;
            r102.W90(r103);
        L12:
            r100.dismiss();
            return;
        L5:
            if (r101 != (-1)) goto L12;
            FixedUploadFileFragment r105 = this.f39075a;
            FragmentActivity r106 = this.f39077c;
            String r107 = this.f39078d;
            Intent r108 = this.f39079e;
            int r109 = FixedUploadFileFragment.f39067i;
            r105.getClass();
            if (com.bytedance.android.annie.bridge.method.permission.c.a(r106, r107) == false) goto L10;
            r105.W90(r108);
            goto L12
        L10:
            r105.f39069e = new com.bytedance.android.annie.business.web.c(r105, r108, r106);
            r105.requestPermissions(new String[]{r107}, 1024);
            goto L12
        }
    }

    static {
    }

    public FixedUploadFileFragment() {
    }

    public final void T90(Uri[] r100) {
        Function1<? super Uri[], Unit> r101 = this.f39070f;
        if (r101 == null) goto L5;
        r101.invoke(r100);
        this.f39070f = null;
    L5:
        this.f39071g = null;
        this.f39072h = false;
    }

    public final void W90(Intent r100) {
        startActivityForResult(r100, 2048);     // Catch: ActivityNotFoundException -> L5
        return;
    L5:
        e = move-exception;
        FragmentActivity r101 = getActivity();
        if (r101 == null) goto L9;
        com.bytedance.android.annie.util.c.b(r101, R.string.hybrid_web_upload_failed);
    L9:
        this.f39072h = true;
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
        String r113 = this.f39071g;
        if (r113 == null) goto L71;
        PolarisFileWrapper r114 = new PolarisFileWrapper(r113);
        if (r114.exists() == false) goto L71;
        r106 = new Uri[]{Uri.fromFile(r114)};
        Context r115 = this.f39068d;
        if (r115 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
        r115 = null;
    L38:
        String r107 = this.f39071g;
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
        if (this.f39072h == false) goto L10;
        this.f39072h = false;
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
        d r104 = this.f39069e;
        if (r104 == null) goto L22;
        r104.onPermissionDenied();
        return;
    L22:
        return;
    L11:
        if (r102[0] != 0) goto L15;
        d r105 = this.f39069e;
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

    public final boolean U90(Function1<? super Uri[], Unit> r110, String[] r111, boolean r210, boolean r211) {
        Intrinsics.checkNotNullParameter(r110, "chooseFileCallback");
        this.f39070f = r110;
        if (r111 == null) goto L59;
        Context r100 = null;
        if (r210 == false) goto L42;
        int r112 = r111.length;
        int r113 = 0;
    L7:
        if (r113 >= r112) goto L59;
        String r114 = r111[r113];
        if (StringsKt.startsWith$default(r114, "image", false, 2, null) == true) goto L10;
        if (StringsKt.startsWith$default(r114, "video", false, 2, null) == true) goto L35;
        if (StringsKt.startsWith$default(r114, "audio", false, 2, null) == true) goto L39;
        r113 = r113 + 1;
        goto L7
    L39:
        V90("android.permission.RECORD_AUDIO", R.string.hybrid_web_upload_record_audio, new Intent("android.provider.MediaStore.RECORD_SOUND"), R.string.hybrid_web_upload_local_audio, S90(false, false, true, r211));
        return true;
    L35:
        V90("android.permission.CAMERA", R.string.hybrid_web_upload_record_video, new Intent("android.media.action.VIDEO_CAPTURE"), R.string.hybrid_web_upload_local_video, S90(false, true, false, r211));
        return true;
    L10:
        Intent r101 = new Intent("android.media.action.IMAGE_CAPTURE");
        Context r102 = this.f39068d;
        if (r102 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
        r102 = null;
    L13:
        File r103 = r102.getExternalFilesDir(Environment.DIRECTORY_DCIM);
        if (r103 != null) goto L19;
        Context r115 = this.f39068d;
        if (r115 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
        r115 = null;
    L18:
        r103 = new PolarisFileWrapper(r115.getFilesDir(), Environment.DIRECTORY_DCIM);
    L19:
        StringBuilder r116 = new StringBuilder();
        r116.append(r103.getAbsolutePath());
        String r104 = File.separator;
        r116.append(r104);
        r116.append("browser-photos");
        PolarisFileWrapper r117 = new PolarisFileWrapper(r116.toString());
        r117.mkdirs();
        String r105 = r117.getAbsolutePath() + r104 + System.currentTimeMillis() + ".jpg";
        this.f39071g = r105;
        Context r118 = this.f39068d;
        if (r118 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
    L23:
        PolarisFileWrapper r106 = new PolarisFileWrapper(r105);
        if (r100 != null) goto L26;
    L30:
        Uri r107 = Uri.fromFile(r106);
    L31:
        r101.putExtra(BdpAppEventConstant.PARAMS_OUTPUT, r107);
        V90("android.permission.CAMERA", R.string.hybrid_web_upload_record_image, r101, R.string.hybrid_web_upload_local_image, S90(true, false, false, r211));
        return true;
    L26:
        if (Build.VERSION.SDK_INT < 24) goto L30;
        if (r100.getApplicationInfo().targetSdkVersion < 24) goto L30;
        r107 = FileProvider.getUriForFile(r100, r100.getPackageName() + ".fileprovider", r106);
        goto L31
    L22:
        r100 = r118;
        goto L23
    L42:
        int r119 = r111.length;
        int r120 = 0;
        boolean r121 = false;
        boolean r122 = false;
        boolean r123 = false;
    L43:
        if (r120 >= r119) goto L54;
        String r124 = r111[r120];
        if (StringsKt.startsWith$default(r124, "image", false, 2, null) == false) goto L48;
        r121 = true;
    L53:
        r120 = r120 + 1;
        goto L43
    L48:
        if (StringsKt.startsWith$default(r124, "video", false, 2, null) == false) goto L51;
        r122 = true;
        goto L53
    L51:
        if (StringsKt.startsWith$default(r124, "audio", false, 2, null) == false) goto L53;
        r123 = true;
        goto L53
    L54:
        if (r121 == true) goto L57;
        if (r122 == true) goto L57;
        if (r123 == false) goto L59;
    L57:
        W90(S90(r121, r122, r123, r211));
        return true;
    L59:
        W90(S90(true, true, true, r211));
        return true;
    }

    public final void V90(String r110, int r111, Intent r112, int r113, Intent r114) {
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
