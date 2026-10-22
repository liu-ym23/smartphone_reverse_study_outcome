package com.stepos.ailauncher.task.detail.download;

import La.D;
import La.H;
import P6.DocumentPreviewResponse;
import P6.DownloadUrlResponse;
import Ua.C1060i;
import Y8.t;
import Z8.C1172u;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import Z8.Q;
import Z8.Y;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.C1398p;
import android.view.LifecycleOwner;
import android.webkit.MimeTypeMap;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import com.stepos.ailauncher.task.R$string;
import com.stepos.ailauncher.task.detail.C3565w;
import com.stepos.ailauncher.task.detail.DownloadOption;
import com.stepos.ailauncher.task.detail.render.ArtifactRenderKind;
import com.stepos.common.utils.filestorage.FileStorageManager;
import com.stepos.common.utils.filestorage.exceptions.FileStorageException;
import com.stepos.widget.recipient.StepOSRecipientEmailHistory;
import h8.C4148a;
import i6.C4171a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import l9.C4877a;
import net.sqlcipher.database.SQLiteDatabase;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import tb.AbstractC5531D;
import tb.C5528A;
import tb.C5530C;
import tb.z;
import u6.C5578a;
import v9.C5685n;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 `2\u00020\u0001:\u0001\u001bB7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0012\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0016H\u0002¢\u0006\u0004\b#\u0010\u001dJ\u0017\u0010$\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b$\u0010\"J\u001f\u0010(\u001a\u00020\u00062\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u0005H\u0002¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b*\u0010\"J\u001f\u0010,\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b,\u0010-J\u001f\u0010/\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u001eH\u0002¢\u0006\u0004\b/\u00100J\u0019\u00102\u001a\u0004\u0018\u00010%2\u0006\u00101\u001a\u00020\bH\u0002¢\u0006\u0004\b2\u00103J\u0019\u00104\u001a\u0004\u0018\u00010%2\u0006\u00101\u001a\u00020\bH\u0002¢\u0006\u0004\b4\u00103J\u0017\u00105\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\bH\u0002¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b7\u00108J+\u0010:\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00060\u0004H\u0002¢\u0006\u0004\b:\u0010;J+\u0010<\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00060\u0004H\u0002¢\u0006\u0004\b<\u0010=JK\u0010D\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u00162\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00060?2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00060?2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00060?2\b\b\u0002\u0010C\u001a\u00020\u0005H\u0002¢\u0006\u0004\bD\u0010EJ+\u0010I\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\u001e2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020\u00060\u0004H\u0002¢\u0006\u0004\bI\u0010JJ'\u0010M\u001a\u00020\u00062\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010L\u001a\u0004\u0018\u00010KH\u0002¢\u0006\u0004\bM\u0010NJ\u0019\u0010P\u001a\u00020\u001e2\b\u0010O\u001a\u0004\u0018\u00010KH\u0002¢\u0006\u0004\bP\u0010QJ\r\u0010R\u001a\u00020\u0006¢\u0006\u0004\bR\u0010SJ\u0017\u0010T\u001a\u00020\u00062\b\u0010>\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\bT\u0010UJ\u0015\u0010V\u001a\u00020\u00062\u0006\u00101\u001a\u00020\b¢\u0006\u0004\bV\u0010WR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010XR \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010YR \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010YR\u0018\u0010Z\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010_\u001a\u00020\\8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b]\u0010^¨\u0006a"}, d2 = {"Lcom/stepos/ailauncher/task/detail/download/ArtifactDownloadController;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Lkotlin/Function1;", "", "LY8/t;", "onDownloadingChanged", "Ljava/io/File;", "onSaved", "<init>", "(Landroidx/fragment/app/Fragment;Lp9/l;Lp9/l;)V", "", "resultCode", "Landroid/content/Intent;", "data", "Lcom/stepos/ailauncher/task/detail/x;", "option", ExifInterface.LATITUDE_SOUTH, "(ILandroid/content/Intent;Lcom/stepos/ailauncher/task/detail/x;)V", ExifInterface.LONGITUDE_WEST, "(Landroid/content/Intent;)Ljava/io/File;", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "current", "", "y", "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;)Ljava/util/List;", Const.INTENT_KEY_APIKEY, "H", "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;)Z", "", ExifInterface.LONGITUDE_EAST, "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;)Ljava/lang/String;", "e0", "(Lcom/stepos/ailauncher/task/detail/x;)V", "G", "f0", "Landroid/net/Uri;", "uri", "success", "D", "(Landroid/net/Uri;Z)V", ExifInterface.GPS_DIRECTION_TRUE, Const.JSON_KEY_DIR, "M", "(Ljava/io/File;Lcom/stepos/ailauncher/task/detail/x;)V", "fileName", "n0", "(Ljava/io/File;Ljava/lang/String;)Ljava/io/File;", Const.STR_FILE, "I", "(Ljava/io/File;)Landroid/net/Uri;", "U", "J", "(Ljava/io/File;)Ljava/lang/String;", "z", "(Lcom/stepos/ailauncher/task/detail/x;)Ljava/lang/String;", "onUrl", "X", "(Lcom/stepos/ailauncher/task/detail/x;Lp9/l;)V", "o0", "(Lcom/stepos/ailauncher/task/detail/x;Lp9/l;)Z", "artifact", "Lkotlin/Function0;", "write", "onSuccess", "onFailure", "silentSuccessToast", "c0", "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;Lp9/a;Lp9/a;Lp9/a;Z)V", "url", "Ljava/io/InputStream;", "sink", "B", "(Ljava/lang/String;Lp9/l;)V", "", "cause", "K", "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;Ljava/lang/Throwable;)V", "e", "C", "(Ljava/lang/Throwable;)Ljava/lang/String;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "()V", "l0", "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;)V", "p0", "(Ljava/io/File;)V", "Landroidx/fragment/app/Fragment;", "Lp9/l;", "pendingOption", "Lcom/stepos/ailauncher/task/detail/x;", "Landroid/content/Context;", "F", "()Landroid/content/Context;", "context", "Companion", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArtifactDownloadController {
    private static final String ACTION_FM_VIEW_DIRECTORY = "com.stepos.filemanager.action.VIEW_DIRECTORY";
    private static final String ACTION_FM_VIEW_FILE = "com.stepos.filemanager.action.VIEW_FILE";
    private static final String ACTION_SAVE_FILE = "com.stepos.action.SAVE_FILE";
    private static final String EXTRA_CHOOSE_DIRECTORY = "choose_directory";
    private static final String EXTRA_FM_CHECK_AFTER_SCROLL = "is_check_after_scroll_to";
    private static final String EXTRA_FM_CURRENT_PATH = "init_directory";
    private static final String EXTRA_FM_SCROLL_TO_POSITION = "is_scroll_to_position";
    private static final String EXTRA_FM_SELECTED_FILE = "selected_file";
    private static final String EXTRA_FM_TARGET_PROMPT = "is_target_prompt_scroll_to";
    private static final String PKG_FILE_MANAGER = "com.stepos.filemanager";
    private static final String TAG = "ArtifactDownload";
    private final Fragment fragment;
    private final InterfaceC5074l<Boolean, t> onDownloadingChanged;
    private final InterfaceC5074l<File, t> onSaved;
    private DownloadOption pendingOption;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<String> GALLERY_IMAGE_EXTS = Y.j(C5578a.DST_JPG, "jpeg", "png", "webp", "gif", "bmp", "heic", "heif");
    private static final Y8.h<z> downloadClient$delegate = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.download.a
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return ArtifactDownloadController.A();
        }
    });

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\"\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0014\u0010\u0012\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\fR\u0014\u0010\u0014\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\fR\u0014\u0010\u0015\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\fR\u0014\u0010\u0016\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\fR\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/task/detail/download/ArtifactDownloadController$a;", "", "<init>", "()V", "Ltb/z;", "downloadClient$delegate", "LY8/h;", Const.INTENT_KEY_PKGNAME, "()Ltb/z;", "downloadClient", "", "TAG", "Ljava/lang/String;", "ACTION_SAVE_FILE", "EXTRA_CHOOSE_DIRECTORY", "PKG_FILE_MANAGER", "ACTION_FM_VIEW_FILE", "ACTION_FM_VIEW_DIRECTORY", "EXTRA_FM_CURRENT_PATH", "EXTRA_FM_SELECTED_FILE", "EXTRA_FM_SCROLL_TO_POSITION", "EXTRA_FM_CHECK_AFTER_SCROLL", "EXTRA_FM_TARGET_PROMPT", "", "GALLERY_IMAGE_EXTS", "Ljava/util/Set;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.task.detail.download.ArtifactDownloadController$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final z b() {
            return (z) ArtifactDownloadController.downloadClient$delegate.getValue();
        }

        public Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArtifactDownloadController(Fragment fragment, InterfaceC5074l<? super Boolean, t> onDownloadingChanged, InterfaceC5074l<? super File, t> onSaved) {
        kotlin.jvm.internal.p.i(fragment, "fragment");
        kotlin.jvm.internal.p.i(onDownloadingChanged, "onDownloadingChanged");
        kotlin.jvm.internal.p.i(onSaved, "onSaved");
        this.fragment = fragment;
        this.onDownloadingChanged = onDownloadingChanged;
        this.onSaved = onSaved;
    }

    public static final z A() {
        z.a aVar = new z.a();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return aVar.g(30L, timeUnit).T(30L, timeUnit).W(30L, timeUnit).d();
    }

    public static /* synthetic */ void L(ArtifactDownloadController artifactDownloadController, SessionArtifact sessionArtifact, Throwable th, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            sessionArtifact = null;
        }
        if ((i10 & 2) != 0) {
            th = null;
        }
        artifactDownloadController.K(sessionArtifact, th);
    }

    public static final t N(final ArtifactDownloadController artifactDownloadController, File file, DownloadOption downloadOption, final String url) {
        kotlin.jvm.internal.p.i(url, "url");
        final File fileN0 = artifactDownloadController.n0(file, artifactDownloadController.z(downloadOption));
        artifactDownloadController.c0(downloadOption.getArtifact(), new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.download.d
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ArtifactDownloadController.O(this.f28542a, url, fileN0);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.download.e
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ArtifactDownloadController.Q(fileN0, artifactDownloadController);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.download.f
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ArtifactDownloadController.R(fileN0);
            }
        }, true);
        return t.f7040a;
    }

    public static final t O(ArtifactDownloadController artifactDownloadController, String str, final File file) throws IOException {
        artifactDownloadController.B(str, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.download.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ArtifactDownloadController.P(file, (InputStream) obj);
            }
        });
        return t.f7040a;
    }

    public static final t P(File file, InputStream input) throws IOException {
        kotlin.jvm.internal.p.i(input, "input");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            C4877a.b(input, fileOutputStream, 0, 2, null);
            t tVar = t.f7040a;
            l9.b.a(fileOutputStream, null);
            return t.f7040a;
        } finally {
        }
    }

    public static final t Q(File file, ArtifactDownloadController artifactDownloadController) {
        C4148a.k(TAG, "saved path=" + file.getAbsolutePath() + " size=" + file.length(), false, 4, null);
        try {
            Result.Companion companion = Result.INSTANCE;
            MediaScannerConnection.scanFile(artifactDownloadController.F(), new String[]{file.getAbsolutePath()}, new String[]{artifactDownloadController.J(file)}, null);
            Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        artifactDownloadController.onSaved.invoke(file);
        return t.f7040a;
    }

    public static final t R(File file) {
        file.delete();
        return t.f7040a;
    }

    public static final t Y(InterfaceC5074l interfaceC5074l, DocumentPreviewResponse resp) {
        kotlin.jvm.internal.p.i(resp, "resp");
        interfaceC5074l.invoke(resp.getPreviewUrl());
        return t.f7040a;
    }

    public static final t Z(String str, ArtifactDownloadController artifactDownloadController, DownloadOption downloadOption, Throwable e10) {
        kotlin.jvm.internal.p.i(e10, "e");
        C4148a.t(TAG, "getPreviewUrl(pdf) failed fileId=" + str, e10, false, 8, null);
        artifactDownloadController.K(downloadOption.getArtifact(), e10);
        return t.f7040a;
    }

    public static final t a0(InterfaceC5074l interfaceC5074l, DownloadUrlResponse resp) {
        kotlin.jvm.internal.p.i(resp, "resp");
        interfaceC5074l.invoke(resp.getDownloadUrl());
        return t.f7040a;
    }

    public static final t b0(String str, ArtifactDownloadController artifactDownloadController, DownloadOption downloadOption, InterfaceC5074l interfaceC5074l, Throwable e10) {
        kotlin.jvm.internal.p.i(e10, "e");
        C4148a.t(TAG, "getDownloadUrl failed fileId=" + str, e10, false, 8, null);
        if (!artifactDownloadController.o0(downloadOption, interfaceC5074l)) {
            L(artifactDownloadController, downloadOption.getArtifact(), null, 2, null);
        }
        return t.f7040a;
    }

    public static /* synthetic */ void d0(ArtifactDownloadController artifactDownloadController, SessionArtifact sessionArtifact, InterfaceC5063a interfaceC5063a, InterfaceC5063a interfaceC5063a2, InterfaceC5063a interfaceC5063a3, boolean z10, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            z10 = false;
        }
        artifactDownloadController.c0(sessionArtifact, interfaceC5063a, interfaceC5063a2, interfaceC5063a3, z10);
    }

    public static final t g0(final ArtifactDownloadController artifactDownloadController, DownloadOption downloadOption, final Uri uri, final String url) {
        kotlin.jvm.internal.p.i(url, "url");
        d0(artifactDownloadController, downloadOption.getArtifact(), new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.download.j
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ArtifactDownloadController.h0(this.f28553a, url, uri);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.download.k
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ArtifactDownloadController.j0(this.f28556a, uri);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.download.l
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ArtifactDownloadController.k0(this.f28558a, uri);
            }
        }, false, 16, null);
        return t.f7040a;
    }

    public static final t h0(final ArtifactDownloadController artifactDownloadController, String str, final Uri uri) throws IOException {
        artifactDownloadController.B(str, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.download.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ArtifactDownloadController.i0(this.f28540a, uri, (InputStream) obj);
            }
        });
        return t.f7040a;
    }

    public static final t i0(ArtifactDownloadController artifactDownloadController, Uri uri, InputStream input) throws IOException {
        kotlin.jvm.internal.p.i(input, "input");
        OutputStream outputStreamOpenOutputStream = artifactDownloadController.F().getContentResolver().openOutputStream(uri);
        if (outputStreamOpenOutputStream == null) {
            throw new IOException("openOutputStream null");
        }
        try {
            C4877a.b(input, outputStreamOpenOutputStream, 0, 2, null);
            l9.b.a(outputStreamOpenOutputStream, null);
            return t.f7040a;
        } finally {
        }
    }

    public static final t j0(ArtifactDownloadController artifactDownloadController, Uri uri) {
        artifactDownloadController.D(uri, true);
        return t.f7040a;
    }

    public static final t k0(ArtifactDownloadController artifactDownloadController, Uri uri) {
        artifactDownloadController.D(uri, false);
        return t.f7040a;
    }

    public static final t m0(ArtifactDownloadController artifactDownloadController, DownloadOption sel) throws FileStorageException.NotInitialized {
        kotlin.jvm.internal.p.i(sel, "sel");
        artifactDownloadController.e0(sel);
        return t.f7040a;
    }

    public final void B(String url, InterfaceC5074l<? super InputStream, t> sink) throws IOException {
        C5530C c5530cExecute = INSTANCE.b().a(new C5528A.a().t(url).b()).execute();
        try {
            if (!c5530cExecute.getIsSuccessful()) {
                throw new IOException("HTTP " + c5530cExecute.getCode());
            }
            AbstractC5531D body = c5530cExecute.getBody();
            if (body == null) {
                throw new IOException("Empty response body");
            }
            sink.invoke(body.b());
            t tVar = t.f7040a;
            l9.b.a(c5530cExecute, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                l9.b.a(c5530cExecute, th);
                throw th2;
            }
        }
    }

    public final String C(Throwable e10) {
        String message = e10 != null ? e10.getMessage() : null;
        if (message == null) {
            message = "";
        }
        return H.g0(message, "403", false, 2, null) ? M5.c.FAIL_EXPIRED : H.g0(message, "404", false, 2, null) ? "file_not_found" : M5.c.FAIL_NETWORK;
    }

    public final void D(Uri uri, boolean success) {
        Object objB;
        int iDelete;
        try {
            Result.Companion companion = Result.INSTANCE;
            if (success) {
                ContentResolver contentResolver = F().getContentResolver();
                ContentValues contentValues = new ContentValues();
                contentValues.put("is_pending", (Integer) 0);
                t tVar = t.f7040a;
                iDelete = contentResolver.update(uri, contentValues, null, null);
            } else {
                iDelete = F().getContentResolver().delete(uri, null, null);
            }
            objB = Result.b(Integer.valueOf(iDelete));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "finalizeGalleryUri failed success=" + success, thE, false, 8, null);
        }
    }

    public final String E(SessionArtifact a10) {
        String strC = ArtifactRenderKind.INSTANCE.c(a10);
        if (strC == null) {
            return "FILE";
        }
        String upperCase = strC.toUpperCase(Locale.ROOT);
        kotlin.jvm.internal.p.h(upperCase, "toUpperCase(...)");
        return upperCase == null ? "FILE" : upperCase;
    }

    public final Context F() {
        Context contextRequireContext = this.fragment.requireContext();
        kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
        return contextRequireContext;
    }

    public final boolean G(SessionArtifact a10) {
        String strC;
        ArtifactRenderKind artifactRenderKind = ArtifactRenderKind.INSTANCE;
        if (artifactRenderKind.g(a10) == ArtifactRenderKind.Kind.IMAGE && (strC = artifactRenderKind.c(a10)) != null) {
            String lowerCase = strC.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
            if (lowerCase != null) {
                return GALLERY_IMAGE_EXTS.contains(lowerCase);
            }
        }
        return false;
    }

    public final boolean H(SessionArtifact a10) {
        String lowerCase;
        Set setJ = Y.j(ChatTracker.CONTENT_PPT, "pptx");
        String strC = ArtifactRenderKind.INSTANCE.c(a10);
        if (strC != null) {
            lowerCase = strC.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        return F.f0(setJ, lowerCase);
    }

    public final Uri I(File file) {
        Uri uriU = U(file);
        if (uriU != null) {
            return uriU;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            MediaScannerConnection.scanFile(F(), new String[]{file.getAbsolutePath()}, new String[]{J(file)}, null);
            Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        return U(file);
    }

    public final String J(File file) {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String lowerCase = l9.k.w(file).toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        String mimeTypeFromExtension = singleton.getMimeTypeFromExtension(lowerCase);
        return mimeTypeFromExtension == null ? "application/octet-stream" : mimeTypeFromExtension;
    }

    public final void K(SessionArtifact artifact, Throwable cause) {
        this.onDownloadingChanged.invoke(Boolean.FALSE);
        if (artifact != null) {
            String sessionId = artifact.getSessionId();
            M5.c.o(M5.c.INSTANCE, artifact, (sessionId == null || sessionId.length() <= 0) ? null : sessionId, "failed", C(cause), null, 16, null);
        }
        Toast.makeText(F(), R$string.task_detail_download_failed, 0).show();
    }

    public final void M(final File dir, final DownloadOption option) throws FileStorageException.NotInitialized {
        this.onDownloadingChanged.invoke(Boolean.TRUE);
        X(option, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.download.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ArtifactDownloadController.N(this.f28537a, dir, option, (String) obj);
            }
        });
    }

    public final void S(int resultCode, Intent data, DownloadOption option) throws FileStorageException.NotInitialized {
        LinkedHashMap linkedHashMap;
        Bundle extras;
        Set<String> setKeySet;
        Uri data2 = data != null ? data.getData() : null;
        if (data == null || (extras = data.getExtras()) == null || (setKeySet = extras.keySet()) == null) {
            linkedHashMap = null;
        } else {
            Set<String> set = setKeySet;
            linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(set, 10)), 16));
            for (Object obj : set) {
                String str = (String) obj;
                Bundle extras2 = data.getExtras();
                linkedHashMap.put(obj, extras2 != null ? extras2.get(str) : null);
            }
        }
        C4148a.k(TAG, "onDirPickResult code=" + resultCode + " data=" + data2 + " extras=" + linkedHashMap, false, 4, null);
        if (resultCode != -1) {
            return;
        }
        File fileW = W(data);
        if (fileW == null) {
            C4148a.u(TAG, "no writable directory in result data=" + data, false, 4, null);
            Toast.makeText(F(), R$string.task_detail_download_failed, 0).show();
            return;
        }
        C4148a.k(TAG, "chosen dir=" + fileW.getAbsolutePath() + " canWrite=" + fileW.canWrite(), false, 4, null);
        M(fileW, option);
    }

    public final void T(DownloadOption option) {
        Context contextF = F();
        Intent intent = new Intent(ACTION_SAVE_FILE);
        intent.putExtra(EXTRA_FM_CURRENT_PATH, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath());
        String strC = C4171a.c(contextF, intent);
        if (strC == null) {
            C4148a.u(TAG, "launch dir picker relay failed", false, 4, null);
            L(this, option.getArtifact(), null, 2, null);
        } else {
            this.pendingOption = option;
            LifecycleOwner viewLifecycleOwner = this.fragment.getViewLifecycleOwner();
            kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new ArtifactDownloadController$pickDirThenWrite$1(this, strC, null), 3, null);
        }
    }

    public final Uri U(File file) {
        Object objB;
        Uri uriWithAppendedId;
        try {
            Result.Companion companion = Result.INSTANCE;
            Cursor cursorQuery = F().getContentResolver().query(MediaStore.Files.getContentUri("external"), new String[]{StepOSRecipientEmailHistory._ID}, "_data=?", new String[]{file.getAbsolutePath()}, null);
            if (cursorQuery != null) {
                Cursor cursor = cursorQuery;
                try {
                    Cursor cursor2 = cursor;
                    uriWithAppendedId = cursor2.moveToFirst() ? ContentUris.withAppendedId(MediaStore.Files.getContentUri("external"), cursor2.getLong(0)) : null;
                    l9.b.a(cursor, null);
                } finally {
                }
            } else {
                uriWithAppendedId = null;
            }
            objB = Result.b(uriWithAppendedId);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (Uri) (Result.g(objB) ? null : objB);
    }

    public final void V() {
        this.pendingOption = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.io.File W(android.content.Intent r3) {
        /*
            r2 = this;
            r2 = 0
            if (r3 == 0) goto L15
            java.lang.String r0 = "choose_directory"
            java.lang.String r0 = r3.getStringExtra(r0)
            if (r0 == 0) goto L15
            boolean r1 = La.H.x0(r0)
            if (r1 != 0) goto L12
            goto L13
        L12:
            r0 = r2
        L13:
            if (r0 != 0) goto L31
        L15:
            if (r3 == 0) goto L2d
            android.net.Uri r3 = r3.getData()
            if (r3 == 0) goto L2d
            java.lang.String r3 = r3.getPath()
            if (r3 == 0) goto L2d
            boolean r0 = La.H.x0(r3)
            if (r0 != 0) goto L2a
            goto L2b
        L2a:
            r3 = r2
        L2b:
            r0 = r3
            goto L2e
        L2d:
            r0 = r2
        L2e:
            if (r0 != 0) goto L31
            return r2
        L31:
            java.io.File r3 = new java.io.File
            r3.<init>(r0)
            boolean r0 = r3.isDirectory()
            if (r0 == 0) goto L43
            boolean r0 = r3.canWrite()
            if (r0 == 0) goto L43
            return r3
        L43:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.detail.download.ArtifactDownloadController.W(android.content.Intent):java.io.File");
    }

    public final void X(final DownloadOption option, final InterfaceC5074l<? super String, t> onUrl) throws FileStorageException.NotInitialized {
        final String fileId = option.getArtifact().getFileId();
        if (fileId == null || H.x0(fileId)) {
            if (o0(option, onUrl)) {
                return;
            }
            L(this, option.getArtifact(), null, 2, null);
        } else if (option.getAsPdfFromPreview()) {
            FileStorageManager.INSTANCE.k(fileId, "pdf", 600, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.download.m
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return ArtifactDownloadController.Y(onUrl, (DocumentPreviewResponse) obj);
                }
            }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.download.n
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return ArtifactDownloadController.Z(fileId, this, option, (Throwable) obj);
                }
            });
        } else {
            FileStorageManager.j(FileStorageManager.INSTANCE, fileId, null, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.download.o
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return ArtifactDownloadController.a0(onUrl, (DownloadUrlResponse) obj);
                }
            }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.download.p
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return ArtifactDownloadController.b0(fileId, this, option, onUrl, (Throwable) obj);
                }
            }, 6, null);
        }
    }

    public final void c0(SessionArtifact artifact, InterfaceC5063a<t> write, InterfaceC5063a<t> onSuccess, InterfaceC5063a<t> onFailure, boolean silentSuccessToast) {
        C1060i.d(C1398p.a(this.fragment), Ua.Y.b(), null, new ArtifactDownloadController$runDownload$1(write, this, onFailure, artifact, silentSuccessToast, onSuccess, null), 2, null);
    }

    public final void e0(DownloadOption option) throws FileStorageException.NotInitialized {
        if (option.getAsPdfFromPreview() || !G(option.getArtifact())) {
            T(option);
        } else {
            f0(option);
        }
    }

    public final void f0(final DownloadOption option) throws FileStorageException.NotInitialized {
        SessionArtifact artifact = option.getArtifact();
        String strJ = u6.j.INSTANCE.j(artifact.getMimeType());
        if (strJ == null) {
            String strC = ArtifactRenderKind.INSTANCE.c(artifact);
            if (strC != null) {
                MimeTypeMap singleton = MimeTypeMap.getSingleton();
                String lowerCase = strC.toLowerCase(Locale.ROOT);
                kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
                strJ = singleton.getMimeTypeFromExtension(lowerCase);
            } else {
                strJ = null;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", z(option));
        if (strJ != null) {
            contentValues.put("mime_type", strJ);
        }
        contentValues.put("relative_path", Environment.DIRECTORY_PICTURES + "/AiLauncher");
        contentValues.put("is_pending", (Integer) 1);
        final Uri uriInsert = F().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        if (uriInsert == null) {
            C4148a.u(TAG, "saveImageToGallery insert returned null", false, 4, null);
            L(this, option.getArtifact(), null, 2, null);
        } else {
            this.onDownloadingChanged.invoke(Boolean.TRUE);
            X(option, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.download.i
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return ArtifactDownloadController.g0(this.f28550a, option, uriInsert, (String) obj);
                }
            });
        }
    }

    public final void l0(SessionArtifact artifact) {
        if (artifact == null) {
            return;
        }
        List<DownloadOption> listY = y(artifact);
        if (listY.size() <= 1) {
            e0((DownloadOption) F.q0(listY));
            return;
        }
        C3565w c3565wA = C3565w.INSTANCE.a(listY);
        c3565wA.E(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.download.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ArtifactDownloadController.m0(this.f28549a, (DownloadOption) obj);
            }
        });
        c3565wA.show(this.fragment.getChildFragmentManager(), "download_format");
    }

    public final File n0(File dir, String fileName) {
        File file = new File(dir, fileName);
        if (!file.exists()) {
            return file;
        }
        String strA1 = H.A1(fileName, '.', null, 2, null);
        String str = "";
        String strQ1 = H.q1(fileName, '.', "");
        if (strQ1.length() != 0) {
            str = "." + strQ1;
        }
        int i10 = 1;
        while (true) {
            File file2 = new File(dir, strA1 + "(" + i10 + ")" + str);
            if (!file2.exists()) {
                return file2;
            }
            i10++;
        }
    }

    public final boolean o0(DownloadOption option, InterfaceC5074l<? super String, t> onUrl) {
        String cloudPath = option.getArtifact().getCloudPath();
        if (cloudPath == null || H.x0(cloudPath) || !D.X(cloudPath, "http", false, 2, null)) {
            return false;
        }
        C4148a.k(TAG, "download via cloudPath fallback fileId=" + option.getArtifact().getFileId(), false, 4, null);
        onUrl.invoke(cloudPath);
        return true;
    }

    public final void p0(File file) {
        Object objB;
        Iterator it;
        Intent intent;
        Object objB2;
        kotlin.jvm.internal.p.i(file, "file");
        try {
            Result.Companion companion = Result.INSTANCE;
            String parent = file.getParent();
            List listC = C1172u.c();
            Intent intent2 = new Intent(ACTION_FM_VIEW_FILE);
            intent2.setPackage(PKG_FILE_MANAGER);
            intent2.setData(Uri.fromFile(file));
            intent2.putExtra(EXTRA_FM_SELECTED_FILE, file.getAbsolutePath());
            intent2.putExtra(EXTRA_FM_SCROLL_TO_POSITION, true);
            intent2.putExtra(EXTRA_FM_TARGET_PROMPT, true);
            intent2.putExtra(EXTRA_FM_CHECK_AFTER_SCROLL, false);
            intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            listC.add(intent2);
            if (parent != null) {
                Intent intent3 = new Intent(ACTION_FM_VIEW_DIRECTORY);
                intent3.setPackage(PKG_FILE_MANAGER);
                intent3.putExtra(EXTRA_FM_CURRENT_PATH, parent);
                intent3.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                listC.add(intent3);
            }
            Uri uriI = I(file);
            if (uriI != null) {
                Intent intent4 = new Intent("android.intent.action.VIEW");
                intent4.setDataAndType(uriI, J(file));
                intent4.addFlags(268435457);
                listC.add(intent4);
            }
            it = C1172u.a(listC).iterator();
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        do {
            if (!it.hasNext()) {
                C4148a.u(TAG, "view failed path=" + file.getAbsolutePath(), false, 4, null);
                Toast.makeText(F(), R$string.task_detail_download_failed, 0).show();
                objB = Result.b(t.f7040a);
                Throwable thE = Result.e(objB);
                if (thE != null) {
                    C4148a.t(TAG, "viewInFileManager failed path=" + file.getAbsolutePath(), thE, false, 8, null);
                    return;
                }
                return;
            }
            intent = (Intent) it.next();
            try {
                Result.Companion companion3 = Result.INSTANCE;
                F().startActivity(intent);
                objB2 = Result.b(t.f7040a);
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th2));
            }
        } while (!Result.h(objB2));
        C4148a.k(TAG, "view opened via action=" + intent.getAction() + " path=" + file.getAbsolutePath(), false, 4, null);
    }

    public final List<DownloadOption> y(SessionArtifact current) {
        DownloadOption downloadOption = new DownloadOption(E(current), current, false, 4, null);
        String fileId = current.getFileId();
        return (fileId == null || H.x0(fileId) || !H(current)) ? C1172u.e(downloadOption) : C1173v.p(downloadOption, new DownloadOption("PDF", current, true));
    }

    public final String z(DownloadOption option) {
        return u6.j.INSTANCE.b("", option.getArtifact().getTitle(), option.getArtifact().getFileName(), option.getArtifact().getMimeType(), option.getArtifact().getCloudPath(), System.currentTimeMillis(), option.getAsPdfFromPreview() ? "pdf" : null);
    }
}
