package androidx.activity.result.contract;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.ext.SdkExtensions;
import android.provider.MediaStore;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.core.content.ContextCompat;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\u0018\u00002\u00020\u0001:\u0011\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0014"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts;", "", "()V", "CaptureVideo", "CreateDocument", "GetContent", "GetMultipleContents", "OpenDocument", "OpenDocumentTree", "OpenMultipleDocuments", "PickContact", "PickMultipleVisualMedia", "PickVisualMedia", "RequestMultiplePermissions", "RequestPermission", "StartActivityForResult", "StartIntentSenderForResult", "TakePicture", "TakePicturePreview", "TakeVideo", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ActivityResultContracts {

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0017J\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002J\u001d\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$CaptureVideo;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "", "()V", "createIntent", "Landroid/content/Intent;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "(ILandroid/content/Intent;)Ljava/lang/Boolean;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class CaptureVideo extends ActivityResultContract<Uri, Boolean> {
        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult2(Context r100, Uri r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "input");
            return null;
        }

        public CaptureVideo() {
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r100, Uri r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "input");
            return new Intent("android.media.action.VIDEO_CAPTURE").putExtra(BdpAppEventConstant.PARAMS_OUTPUT, r101);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(Context r100, Uri r101) {
            return getSynchronousResult2(r100, r101);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Boolean parseResult(int r100, Intent r101) {
            if (r100 != (-1)) goto L5;
            boolean r102 = true;
        L7:
            return Boolean.valueOf(r102);
        L5:
            r102 = false;
            goto L7
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r100, Uri r101) {
            return createIntent2(r100, r101);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Boolean parseResult(int r100, Intent r101) {
            return parseResult(r100, r101);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0017\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007\b\u0017¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0017J \u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0005\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$CreateDocument;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "Landroid/net/Uri;", "()V", DBDefinition.MIME_TYPE, "(Ljava/lang/String;)V", "createIntent", "Landroid/content/Intent;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class CreateDocument extends ActivityResultContract<String, Uri> {
        private final String mimeType;

        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult2(Context r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "input");
            return null;
        }

        @Deprecated(message = "Using a wildcard mime type with CreateDocument is not recommended as it breaks the automatic handling of file extensions. Instead, specify the mime type by using the constructor that takes an concrete mime type (e.g.., CreateDocument(\"image/png\")).", replaceWith = @ReplaceWith(expression = "CreateDocument(\"todo/todo\")", imports = {}))
        public CreateDocument() {
            this("*/*");
        }

        public CreateDocument(String r100) {
            Intrinsics.checkNotNullParameter(r100, DBDefinition.MIME_TYPE);
            this.mimeType = r100;
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "input");
            return new Intent("android.intent.action.CREATE_DOCUMENT").setType(this.mimeType).putExtra("android.intent.extra.TITLE", r101);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context r100, String r101) {
            return getSynchronousResult2(r100, r101);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Uri parseResult(int r100, Intent r101) {
            if (r100 != (-1)) goto L5;
            boolean r102 = true;
        L7:
            if (r102 == true) goto L10;
            r101 = null;
        L10:
            if (r101 != null) goto L12;
            return null;
        L12:
            return r101.getData();
        L5:
            r102 = false;
            goto L7
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r100, String r101) {
            return createIntent2(r100, r101);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Uri parseResult(int r100, Intent r101) {
            return parseResult(r100, r101);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0017J \u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006¨\u0006\u0010"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$GetContent;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "Landroid/net/Uri;", "()V", "createIntent", "Landroid/content/Intent;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class GetContent extends ActivityResultContract<String, Uri> {
        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult2(Context r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "input");
            return null;
        }

        public GetContent() {
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "input");
            return new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(r101);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context r100, String r101) {
            return getSynchronousResult2(r100, r101);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Uri parseResult(int r100, Intent r101) {
            if (r100 != (-1)) goto L5;
            boolean r102 = true;
        L7:
            if (r102 == true) goto L10;
            r101 = null;
        L10:
            if (r101 != null) goto L12;
            return null;
        L12:
            return r101.getData();
        L5:
            r102 = false;
            goto L7
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r100, String r101) {
            return createIntent2(r100, r101);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Uri parseResult(int r100, Intent r101) {
            return parseResult(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0017\u0018\u0000 \u00122\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u00030\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0017J$\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002J\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\b¨\u0006\u0013"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$GetMultipleContents;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "Landroid/net/Uri;", "Lkotlin/jvm/JvmSuppressWildcards;", "()V", "createIntent", "Landroid/content/Intent;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "Companion", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class GetMultipleContents extends ActivityResultContract<String, List<Uri>> {
        public static final Companion Companion = null;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$GetMultipleContents$Companion;", "", "()V", "getClipDataUris", "", "Landroid/net/Uri;", "Landroid/content/Intent;", "getClipDataUris$activity_release", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            public final List<Uri> getClipDataUris$activity_release(Intent r100) {
                Intrinsics.checkNotNullParameter(r100, "<this>");
                LinkedHashSet r101 = new LinkedHashSet();
                Uri r102 = r100.getData();
                if (r102 == null) goto L5;
                r101.add(r102);
            L5:
                ClipData r103 = r100.getClipData();
                if (r103 == null) goto L8;
            L11:
                if (r103 == null) goto L19;
                int r104 = r103.getItemCount();
                int r105 = 0;
            L13:
                if (r105 >= r104) goto L19;
                Uri r106 = r103.getItemAt(r105).getUri();
                if (r106 == null) goto L17;
                r101.add(r106);
            L17:
                r105 = r105 + 1;
            L19:
                return new ArrayList(r101);
            L8:
                if (r101.isEmpty() == false) goto L11;
                return CollectionsKt.emptyList();
            }
        }

        static {
            Companion = new Companion(null);
        }

        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult2(Context r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "input");
            return null;
        }

        public GetMultipleContents() {
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "input");
            return new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(r101).putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(Context r100, String r101) {
            return getSynchronousResult2(r100, r101);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: parseResult, reason: avoid collision after fix types in other method */
        public final List<Uri> parseResult2(int r100, Intent r101) {
            if (r100 != (-1)) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == true) goto L9;
            r101 = null;
        L9:
            if (r101 == null) goto L14;
            List<Uri> r103 = Companion.getClipDataUris$activity_release(r101);
            if (r103 == null) goto L14;
            return r103;
        L14:
            return CollectionsKt.emptyList();
        L5:
            r102 = false;
            goto L6
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r100, String r101) {
            return createIntent2(r100, r101);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ List<Uri> parseResult(int r100, Intent r101) {
            return parseResult2(r100, r101);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0017\u0018\u00002\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001B\u0005¢\u0006\u0002\u0010\u0005J#\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0017¢\u0006\u0002\u0010\u000bJ+\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\u0010\u000eJ\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007¨\u0006\u0013"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$OpenDocument;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "Landroid/net/Uri;", "()V", "createIntent", "Landroid/content/Intent;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "input", "(Landroid/content/Context;[Ljava/lang/String;)Landroid/content/Intent;", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "(Landroid/content/Context;[Ljava/lang/String;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class OpenDocument extends ActivityResultContract<String[], Uri> {
        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult2(Context r100, String[] r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "input");
            return null;
        }

        public OpenDocument() {
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r100, String[] r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "input");
            return new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", r101).setType("*/*");
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context r100, String[] r101) {
            return getSynchronousResult2(r100, r101);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Uri parseResult(int r100, Intent r101) {
            if (r100 != (-1)) goto L5;
            boolean r102 = true;
        L7:
            if (r102 == true) goto L10;
            r101 = null;
        L10:
            if (r101 != null) goto L12;
            return null;
        L12:
            return r101.getData();
        L5:
            r102 = false;
            goto L7
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r100, String[] r101) {
            return createIntent2(r100, r101);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Uri parseResult(int r100, Intent r101) {
            return parseResult(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0017\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0017J\"\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005¨\u0006\u000f"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$OpenDocumentTree;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "()V", "createIntent", "Landroid/content/Intent;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class OpenDocumentTree extends ActivityResultContract<Uri, Uri> {
        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult2(Context r100, Uri r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return null;
        }

        public OpenDocumentTree() {
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r100, Uri r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intent r102 = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            if (Build.VERSION.SDK_INT < 26) goto L6;
            if (r101 == null) goto L6;
            r102.putExtra("android.provider.extra.INITIAL_URI", r101);
        L6:
            return r102;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context r100, Uri r101) {
            return getSynchronousResult2(r100, r101);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Uri parseResult(int r100, Intent r101) {
            if (r100 != (-1)) goto L5;
            boolean r102 = true;
        L7:
            if (r102 == true) goto L10;
            r101 = null;
        L10:
            if (r101 != null) goto L12;
            return null;
        L12:
            return r101.getData();
        L5:
            r102 = false;
            goto L7
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r100, Uri r101) {
            return createIntent2(r100, r101);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Uri parseResult(int r100, Intent r101) {
            return parseResult(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0017\u0018\u00002\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0005¢\u0006\u0002\b\u00060\u00040\u0001B\u0005¢\u0006\u0002\u0010\u0007J#\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0017¢\u0006\u0002\u0010\rJ/\u0010\u000e\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\u0010\u0010J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\t¨\u0006\u0015"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$OpenMultipleDocuments;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "", "Landroid/net/Uri;", "Lkotlin/jvm/JvmSuppressWildcards;", "()V", "createIntent", "Landroid/content/Intent;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "input", "(Landroid/content/Context;[Ljava/lang/String;)Landroid/content/Intent;", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "(Landroid/content/Context;[Ljava/lang/String;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class OpenMultipleDocuments extends ActivityResultContract<String[], List<Uri>> {
        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult2(Context r100, String[] r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "input");
            return null;
        }

        public OpenMultipleDocuments() {
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r100, String[] r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "input");
            return new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", r101).putExtra("android.intent.extra.ALLOW_MULTIPLE", true).setType("*/*");
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(Context r100, String[] r101) {
            return getSynchronousResult2(r100, r101);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: parseResult, reason: avoid collision after fix types in other method */
        public final List<Uri> parseResult2(int r100, Intent r101) {
            if (r100 != (-1)) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == true) goto L9;
            r101 = null;
        L9:
            if (r101 == null) goto L14;
            List<Uri> r103 = GetMultipleContents.Companion.getClipDataUris$activity_release(r101);
            if (r103 == null) goto L14;
            return r103;
        L14:
            return CollectionsKt.emptyList();
        L5:
            r102 = false;
            goto L6
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r100, String[] r101) {
            return createIntent2(r100, r101);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ List<Uri> parseResult(int r100, Intent r101) {
            return parseResult2(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u000e"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickContact;", "Landroidx/activity/result/contract/ActivityResultContract;", "Ljava/lang/Void;", "Landroid/net/Uri;", "()V", "createIntent", "Landroid/content/Intent;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PickContact extends ActivityResultContract<Void, Uri> {
        public PickContact() {
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r100, Void r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new Intent("android.intent.action.PICK").setType("vnd.android.cursor.dir/contact");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public Uri parseResult(int r100, Intent r101) {
            if (r100 != (-1)) goto L5;
            boolean r102 = true;
        L7:
            if (r102 == true) goto L10;
            r101 = null;
        L10:
            if (r101 != null) goto L12;
            return null;
        L12:
            return r101.getData();
        L5:
            r102 = false;
            goto L7
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r100, Void r101) {
            return createIntent2(r100, r101);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Uri parseResult(int r100, Intent r101) {
            return parseResult(r100, r101);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000 \u00132\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u00030\u0001:\u0001\u0013B\u000f\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0017J)\u0010\u000e\u001a\u0015\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u0003\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickMultipleVisualMedia;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroidx/activity/result/PickVisualMediaRequest;", "", "Landroid/net/Uri;", "Lkotlin/jvm/JvmSuppressWildcards;", "maxItems", "", "(I)V", "createIntent", "Landroid/content/Intent;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "intent", "Companion", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class PickMultipleVisualMedia extends ActivityResultContract<PickVisualMediaRequest, List<Uri>> {
        public static final Companion Companion = null;
        private final int maxItems;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u00020\u0004H\u0001¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickMultipleVisualMedia$Companion;", "", "()V", "getMaxItems", "", "getMaxItems$activity_release", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            public final int getMaxItems$activity_release() {
                if (PickVisualMedia.Companion.isSystemPickerAvailable$activity_release() == true) goto L7;
                return Integer.MAX_VALUE;
            L7:
                return MediaStore.getPickImagesMaxLimit();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public PickMultipleVisualMedia() {
            int r100 = 0;
            this(r100, 1, null);
        }

        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult2(Context r100, PickVisualMediaRequest r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "input");
            return null;
        }

        public PickMultipleVisualMedia(int r100) {
            this.maxItems = r100;
            boolean r101 = true;
            if (r100 > 1) goto L6;
            r101 = false;
        L6:
            if (r101 == false) goto L9;
            return;
        L9:
            throw new IllegalArgumentException("Max items must be higher than 1".toString());
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r100, PickVisualMediaRequest r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "input");
            PickVisualMedia.Companion r102 = PickVisualMedia.Companion;
            boolean r103 = true;
            if (r102.isSystemPickerAvailable$activity_release() == false) goto L13;
            Intent r104 = new Intent("android.provider.action.PICK_IMAGES");
            r104.setType(r102.getVisualMimeType$activity_release(r101.getMediaType()));
            if (this.maxItems <= MediaStore.getPickImagesMaxLimit()) goto L8;
            r103 = false;
        L8:
            if (r103 == false) goto L11;
            r104.putExtra("android.provider.extra.PICK_IMAGES_MAX", this.maxItems);
            return r104;
        L11:
            throw new IllegalArgumentException("Max items must be less or equals MediaStore.getPickImagesMaxLimit()".toString());
        L13:
            if (r102.isSystemFallbackPickerAvailable$activity_release(r100) == false) goto L20;
            ResolveInfo r105 = r102.getSystemFallbackPicker$activity_release(r100);
            if (r105 == null) goto L18;
            ActivityInfo r106 = r105.activityInfo;
            Intent r107 = new Intent(PickVisualMedia.ACTION_SYSTEM_FALLBACK_PICK_IMAGES);
            r107.setClassName(r106.applicationInfo.packageName, r106.name);
            r107.setType(r102.getVisualMimeType$activity_release(r101.getMediaType()));
            r107.putExtra(PickVisualMedia.GMS_EXTRA_PICK_IMAGES_MAX, this.maxItems);
            return r107;
        L18:
            throw new IllegalStateException("Required value was null.".toString());
        L20:
            if (r102.isGmsPickerAvailable$activity_release(r100) == false) goto L26;
            ResolveInfo r108 = r102.getGmsPicker$activity_release(r100);
            if (r108 == null) goto L25;
            ActivityInfo r109 = r108.activityInfo;
            Intent r110 = new Intent(PickVisualMedia.GMS_ACTION_PICK_IMAGES);
            r110.setClassName(r109.applicationInfo.packageName, r109.name);
            r110.putExtra(PickVisualMedia.GMS_EXTRA_PICK_IMAGES_MAX, this.maxItems);
            return r110;
        L25:
            throw new IllegalStateException("Required value was null.".toString());
        L26:
            Intent r111 = new Intent("android.intent.action.OPEN_DOCUMENT");
            r111.setType(r102.getVisualMimeType$activity_release(r101.getMediaType()));
            r111.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            if (r111.getType() != null) goto L33;
            r111.setType("*/*");
            r111.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
            return r111;
        L33:
            return r111;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(Context r100, PickVisualMediaRequest r101) {
            return getSynchronousResult2(r100, r101);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: parseResult, reason: avoid collision after fix types in other method */
        public final List<Uri> parseResult2(int r100, Intent r101) {
            if (r100 != (-1)) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == true) goto L9;
            r101 = null;
        L9:
            if (r101 == null) goto L14;
            List<Uri> r103 = GetMultipleContents.Companion.getClipDataUris$activity_release(r101);
            if (r103 == null) goto L14;
            return r103;
        L14:
            return CollectionsKt.emptyList();
        L5:
            r102 = false;
            goto L6
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r100, PickVisualMediaRequest r101) {
            return createIntent2(r100, r101);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ List<Uri> parseResult(int r100, Intent r101) {
            return parseResult2(r100, r101);
        }

        public /* synthetic */ PickMultipleVisualMedia(int r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = Companion.getMaxItems$activity_release();
        L5:
            this(r100);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0017\u0018\u0000 \u00102\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0006\u0010\u0011\u0012\u0013\u0014\u0015B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0017J \u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006¨\u0006\u0016"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroidx/activity/result/PickVisualMediaRequest;", "Landroid/net/Uri;", "()V", "createIntent", "Landroid/content/Intent;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "Companion", "ImageAndVideo", "ImageOnly", "SingleMimeType", "VideoOnly", "VisualMediaType", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class PickVisualMedia extends ActivityResultContract<PickVisualMediaRequest, Uri> {
        public static final String ACTION_SYSTEM_FALLBACK_PICK_IMAGES = "androidx.activity.result.contract.action.PICK_IMAGES";
        public static final Companion Companion = null;
        public static final String EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_MAX = "androidx.activity.result.contract.extra.PICK_IMAGES_MAX";
        public static final String GMS_ACTION_PICK_IMAGES = "com.google.android.gms.provider.action.PICK_IMAGES";
        public static final String GMS_EXTRA_PICK_IMAGES_MAX = "com.google.android.gms.provider.extra.PICK_IMAGES_MAX";

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0001¢\u0006\u0002\b\u000eJ\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0001¢\u0006\u0002\b\u0010J\u0017\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0014J\u0015\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\rH\u0001¢\u0006\u0002\b\u0017J\b\u0010\u0018\u001a\u00020\u0016H\u0007J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\rH\u0007J\u0015\u0010\u0019\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\rH\u0001¢\u0006\u0002\b\u001aJ\r\u0010\u001b\u001a\u00020\u0016H\u0001¢\u0006\u0002\b\u001cR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0014\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u000e\u0010\b\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$Companion;", "", "()V", "ACTION_SYSTEM_FALLBACK_PICK_IMAGES", "", "getACTION_SYSTEM_FALLBACK_PICK_IMAGES$annotations", "EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_MAX", "getEXTRA_SYSTEM_FALLBACK_PICK_IMAGES_MAX$annotations", "GMS_ACTION_PICK_IMAGES", "GMS_EXTRA_PICK_IMAGES_MAX", "getGmsPicker", "Landroid/content/pm/ResolveInfo;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getGmsPicker$activity_release", "getSystemFallbackPicker", "getSystemFallbackPicker$activity_release", "getVisualMimeType", "input", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "getVisualMimeType$activity_release", "isGmsPickerAvailable", "", "isGmsPickerAvailable$activity_release", "isPhotoPickerAvailable", "isSystemFallbackPickerAvailable", "isSystemFallbackPickerAvailable$activity_release", "isSystemPickerAvailable", "isSystemPickerAvailable$activity_release", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            public static /* synthetic */ void getACTION_SYSTEM_FALLBACK_PICK_IMAGES$annotations() {
            }

            public static /* synthetic */ void getEXTRA_SYSTEM_FALLBACK_PICK_IMAGES_MAX$annotations() {
            }

            @JvmStatic
            public final boolean isSystemPickerAvailable$activity_release() {
                int r100 = Build.VERSION.SDK_INT;
                if (r100 < 33) goto L6;
                return true;
            L6:
                if (r100 >= 30) goto L8;
            L10:
                return false;
            L8:
                if (SdkExtensions.getExtensionVersion(30) < 2) goto L10;
                return true;
            }

            @Deprecated(message = "This method is deprecated in favor of isPhotoPickerAvailable(context) to support the picker provided by updatable system apps", replaceWith = @ReplaceWith(expression = "isPhotoPickerAvailable(context)", imports = {}))
            @JvmStatic
            public final boolean isPhotoPickerAvailable() {
                return isSystemPickerAvailable$activity_release();
            }

            @JvmStatic
            public final ResolveInfo getGmsPicker$activity_release(Context r100) {
                Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
                return r100.getPackageManager().resolveActivity(new Intent(PickVisualMedia.GMS_ACTION_PICK_IMAGES), 1114112);
            }

            @JvmStatic
            public final ResolveInfo getSystemFallbackPicker$activity_release(Context r100) {
                Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
                return r100.getPackageManager().resolveActivity(new Intent(PickVisualMedia.ACTION_SYSTEM_FALLBACK_PICK_IMAGES), 1114112);
            }

            public final String getVisualMimeType$activity_release(VisualMediaType r100) {
                Intrinsics.checkNotNullParameter(r100, "input");
                if ((r100 instanceof ImageOnly) == false) goto L6;
                return "image/*";
            L6:
                if ((r100 instanceof VideoOnly) == false) goto L9;
                return "video/*";
            L9:
                if ((r100 instanceof SingleMimeType) == false) goto L12;
                return ((SingleMimeType) r100).getMimeType();
            L12:
                if ((r100 instanceof ImageAndVideo) == false) goto L16;
                return null;
            L16:
                throw new NoWhenBranchMatchedException();
            }

            @JvmStatic
            public final boolean isGmsPickerAvailable$activity_release(Context r100) {
                Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
                if (getGmsPicker$activity_release(r100) == null) goto L5;
                return true;
            L5:
                return false;
            }

            @JvmStatic
            public final boolean isPhotoPickerAvailable(Context r100) {
                Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
                if (isSystemPickerAvailable$activity_release() == false) goto L5;
            L10:
                return true;
            L5:
                if (isSystemFallbackPickerAvailable$activity_release(r100) == true) goto L10;
                if (isGmsPickerAvailable$activity_release(r100) == true) goto L10;
                return false;
            }

            @JvmStatic
            public final boolean isSystemFallbackPickerAvailable$activity_release(Context r100) {
                Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
                if (getSystemFallbackPicker$activity_release(r100) == null) goto L5;
                return true;
            L5:
                return false;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$ImageAndVideo;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "()V", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class ImageAndVideo implements VisualMediaType {
            public static final ImageAndVideo INSTANCE = null;

            static {
                INSTANCE = new ImageAndVideo();
            }

            private ImageAndVideo() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$ImageOnly;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "()V", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class ImageOnly implements VisualMediaType {
            public static final ImageOnly INSTANCE = null;

            static {
                INSTANCE = new ImageOnly();
            }

            private ImageOnly() {
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$SingleMimeType;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", DBDefinition.MIME_TYPE, "", "(Ljava/lang/String;)V", "getMimeType", "()Ljava/lang/String;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class SingleMimeType implements VisualMediaType {
            private final String mimeType;

            public final String getMimeType() {
                return this.mimeType;
            }

            public SingleMimeType(String r100) {
                Intrinsics.checkNotNullParameter(r100, DBDefinition.MIME_TYPE);
                this.mimeType = r100;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VideoOnly;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "()V", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class VideoOnly implements VisualMediaType {
            public static final VideoOnly INSTANCE = null;

            static {
                INSTANCE = new VideoOnly();
            }

            private VideoOnly() {
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001\u0082\u0001\u0004\u0002\u0003\u0004\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$ImageAndVideo;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$ImageOnly;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$SingleMimeType;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VideoOnly;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public interface VisualMediaType {
        }

        static {
            Companion = new Companion(null);
        }

        @JvmStatic
        public static final ResolveInfo getGmsPicker$activity_release(Context r100) {
            return Companion.getGmsPicker$activity_release(r100);
        }

        @JvmStatic
        public static final ResolveInfo getSystemFallbackPicker$activity_release(Context r100) {
            return Companion.getSystemFallbackPicker$activity_release(r100);
        }

        @JvmStatic
        public static final boolean isGmsPickerAvailable$activity_release(Context r100) {
            return Companion.isGmsPickerAvailable$activity_release(r100);
        }

        @Deprecated(message = "This method is deprecated in favor of isPhotoPickerAvailable(context) to support the picker provided by updatable system apps", replaceWith = @ReplaceWith(expression = "isPhotoPickerAvailable(context)", imports = {}))
        @JvmStatic
        public static final boolean isPhotoPickerAvailable() {
            return Companion.isPhotoPickerAvailable();
        }

        @JvmStatic
        public static final boolean isPhotoPickerAvailable(Context r100) {
            return Companion.isPhotoPickerAvailable(r100);
        }

        @JvmStatic
        public static final boolean isSystemFallbackPickerAvailable$activity_release(Context r100) {
            return Companion.isSystemFallbackPickerAvailable$activity_release(r100);
        }

        @JvmStatic
        public static final boolean isSystemPickerAvailable$activity_release() {
            return Companion.isSystemPickerAvailable$activity_release();
        }

        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult2(Context r100, PickVisualMediaRequest r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "input");
            return null;
        }

        public PickVisualMedia() {
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r100, PickVisualMediaRequest r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "input");
            Companion r102 = Companion;
            if (r102.isSystemPickerAvailable$activity_release() == false) goto L6;
            Intent r103 = new Intent("android.provider.action.PICK_IMAGES");
            r103.setType(r102.getVisualMimeType$activity_release(r101.getMediaType()));
            return r103;
        L6:
            if (r102.isSystemFallbackPickerAvailable$activity_release(r100) == false) goto L14;
            ResolveInfo r104 = r102.getSystemFallbackPicker$activity_release(r100);
            if (r104 == null) goto L12;
            ActivityInfo r105 = r104.activityInfo;
            Intent r106 = new Intent(ACTION_SYSTEM_FALLBACK_PICK_IMAGES);
            r106.setClassName(r105.applicationInfo.packageName, r105.name);
            r106.setType(r102.getVisualMimeType$activity_release(r101.getMediaType()));
        L25:
            return r106;
        L12:
            throw new IllegalStateException("Required value was null.".toString());
        L14:
            if (r102.isGmsPickerAvailable$activity_release(r100) == false) goto L20;
            ResolveInfo r107 = r102.getGmsPicker$activity_release(r100);
            if (r107 == null) goto L19;
            ActivityInfo r108 = r107.activityInfo;
            r106 = new Intent(GMS_ACTION_PICK_IMAGES);
            r106.setClassName(r108.applicationInfo.packageName, r108.name);
            r106.setType(r102.getVisualMimeType$activity_release(r101.getMediaType()));
            goto L25
        L19:
            throw new IllegalStateException("Required value was null.".toString());
        L20:
            Intent r109 = new Intent("android.intent.action.OPEN_DOCUMENT");
            r109.setType(r102.getVisualMimeType$activity_release(r101.getMediaType()));
            if (r109.getType() != null) goto L26;
            r109.setType("*/*");
            r109.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
            return r109;
        L26:
            return r109;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context r100, PickVisualMediaRequest r101) {
            return getSynchronousResult2(r100, r101);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Uri parseResult(int r100, Intent r101) {
            if (r100 != (-1)) goto L5;
            boolean r102 = true;
        L7:
            if (r102 == true) goto L10;
            r101 = null;
        L10:
            if (r101 == null) goto L16;
            Uri r103 = r101.getData();
            if (r103 != null) goto L15;
            r103 = (Uri) CollectionsKt.firstOrNull(GetMultipleContents.Companion.getClipDataUris$activity_release(r101));
        L15:
            return r103;
        L16:
            return null;
        L5:
            r102 = false;
            goto L7
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r100, PickVisualMediaRequest r101) {
            return createIntent2(r100, r101);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Uri parseResult(int r100, Intent r101) {
            return parseResult(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00152%\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0003\u0012\t\u0012\u00070\u0005¢\u0006\u0002\b\u00060\u00040\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0007J#\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0002\u0010\rJ7\u0010\u000e\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0002\u0010\u0010J&\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u0016"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$RequestMultiplePermissions;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "", "", "Lkotlin/jvm/JvmSuppressWildcards;", "()V", "createIntent", "Landroid/content/Intent;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "input", "(Landroid/content/Context;[Ljava/lang/String;)Landroid/content/Intent;", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "(Landroid/content/Context;[Ljava/lang/String;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "Companion", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class RequestMultiplePermissions extends ActivityResultContract<String[], Map<String, Boolean>> {
        public static final String ACTION_REQUEST_PERMISSIONS = "androidx.activity.result.contract.action.REQUEST_PERMISSIONS";
        public static final Companion Companion = null;
        public static final String EXTRA_PERMISSIONS = "androidx.activity.result.contract.extra.PERMISSIONS";
        public static final String EXTRA_PERMISSION_GRANT_RESULTS = "androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS";

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u0000¢\u0006\u0004\b\u000b\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$RequestMultiplePermissions$Companion;", "", "()V", "ACTION_REQUEST_PERMISSIONS", "", "EXTRA_PERMISSIONS", "EXTRA_PERMISSION_GRANT_RESULTS", "createIntent", "Landroid/content/Intent;", "input", "", "createIntent$activity_release", "([Ljava/lang/String;)Landroid/content/Intent;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            public final Intent createIntent$activity_release(String[] r100) {
                Intrinsics.checkNotNullParameter(r100, "input");
                return new Intent(RequestMultiplePermissions.ACTION_REQUEST_PERMISSIONS).putExtra(RequestMultiplePermissions.EXTRA_PERMISSIONS, r100);
            }
        }

        static {
            Companion = new Companion(null);
        }

        public RequestMultiplePermissions() {
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r100, String[] r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "input");
            return Companion.createIntent$activity_release(r101);
        }

        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public ActivityResultContract.SynchronousResult<Map<String, Boolean>> getSynchronousResult2(Context r100, String[] r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "input");
            boolean r102 = true;
            int r103 = 0;
            if (r101.length != 0) goto L5;
            boolean r104 = true;
        L6:
            if (r104 == true) goto L8;
            int r105 = r101.length;
            int r106 = 0;
        L10:
            if (r106 >= r105) goto L18;
            if (ContextCompat.checkSelfPermission(r100, r101[r106]) != 0) goto L14;
            boolean r107 = true;
        L15:
            if (r107 == false) goto L16;
            r106 = r106 + 1;
            goto L10
        L16:
            r102 = false;
            goto L18
        L14:
            r107 = false;
        L18:
            if (r102 == false) goto L23;
            LinkedHashMap r108 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r101.length), 16));
            int r109 = r101.length;
        L20:
            if (r103 >= r109) goto L28;
            Pair r110 = TuplesKt.to(r101[r103], Boolean.TRUE);
            r108.put(r110.getFirst(), r110.getSecond());
            r103 = r103 + 1;
            goto L20
        L28:
            return new ActivityResultContract.SynchronousResult(r108);
        L23:
            return null;
        L8:
            return new ActivityResultContract.SynchronousResult(MapsKt.emptyMap());
        L5:
            r104 = false;
            goto L6
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: parseResult, reason: avoid collision after fix types in other method */
        public Map<String, Boolean> parseResult2(int r100, Intent r101) {
            if (r100 != (-1)) goto L5;
            if (r101 == null) goto L8;
            String[] r102 = r101.getStringArrayExtra(EXTRA_PERMISSIONS);
            int[] r103 = r101.getIntArrayExtra(EXTRA_PERMISSION_GRANT_RESULTS);
            if (r103 == null) goto L23;
            if (r102 == null) goto L23;
            ArrayList r104 = new ArrayList(r103.length);
            int r105 = r103.length;
            int r106 = 0;
        L14:
            if (r106 >= r105) goto L21;
            if (r103[r106] != 0) goto L18;
            boolean r107 = true;
        L19:
            r104.add(Boolean.valueOf(r107));
            r106 = r106 + 1;
            goto L14
        L18:
            r107 = false;
            goto L19
        L21:
            return MapsKt.toMap(CollectionsKt.zip(ArraysKt.filterNotNull(r102), r104));
        L23:
            return MapsKt.emptyMap();
        L8:
            return MapsKt.emptyMap();
        L5:
            return MapsKt.emptyMap();
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r100, String[] r101) {
            return createIntent2(r100, r101);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Map<String, Boolean>> getSynchronousResult(Context r100, String[] r101) {
            return getSynchronousResult2(r100, r101);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Map<String, Boolean> parseResult(int r100, Intent r101) {
            return parseResult2(r100, r101);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J \u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001f\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$RequestPermission;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "()V", "createIntent", "Landroid/content/Intent;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "(ILandroid/content/Intent;)Ljava/lang/Boolean;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class RequestPermission extends ActivityResultContract<String, Boolean> {
        public RequestPermission() {
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "input");
            return RequestMultiplePermissions.Companion.createIntent$activity_release(new String[]{r101});
        }

        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult2(Context r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "input");
            if (ContextCompat.checkSelfPermission(r100, r101) != 0) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == true) goto L10;
            return null;
        L10:
            return new ActivityResultContract.SynchronousResult(Boolean.TRUE);
        L5:
            r102 = false;
            goto L6
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public Boolean parseResult(int r100, Intent r101) {
            if (r101 == null) goto L24;
            if (r100 != (-1)) goto L24;
            int[] r102 = r101.getIntArrayExtra(RequestMultiplePermissions.EXTRA_PERMISSION_GRANT_RESULTS);
            boolean r103 = false;
            if (r102 == null) goto L22;
            int r104 = r102.length;
            int r105 = 0;
        L10:
            if (r105 >= r104) goto L18;
            if (r102[r105] != 0) goto L14;
            boolean r106 = true;
        L15:
            if (r106 == true) goto L16;
            r105 = r105 + 1;
            goto L10
        L16:
            boolean r107 = true;
        L19:
            if (r107 != true) goto L22;
            r103 = true;
            goto L22
        L14:
            r106 = false;
            goto L15
        L18:
            r107 = false;
        L22:
            return Boolean.valueOf(r103);
        L24:
            return Boolean.FALSE;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r100, String r101) {
            return createIntent2(r100, r101);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(Context r100, String r101) {
            return getSynchronousResult2(r100, r101);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Boolean parseResult(int r100, Intent r101) {
            return parseResult(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000e"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/content/Intent;", "Landroidx/activity/result/ActivityResult;", "()V", "createIntent", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "Companion", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class StartActivityForResult extends ActivityResultContract<Intent, ActivityResult> {
        public static final Companion Companion = null;
        public static final String EXTRA_ACTIVITY_OPTIONS_BUNDLE = "androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE";

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult$Companion;", "", "()V", "EXTRA_ACTIVITY_OPTIONS_BUNDLE", "", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r100, Intent r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "input");
            return r101;
        }

        public StartActivityForResult() {
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r100, Intent r101) {
            return createIntent2(r100, r101);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public ActivityResult parseResult(int r100, Intent r101) {
            return new ActivityResult(r100, r101);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResult parseResult(int r100, Intent r101) {
            return parseResult(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u000e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u000f"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$StartIntentSenderForResult;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroidx/activity/result/IntentSenderRequest;", "Landroidx/activity/result/ActivityResult;", "()V", "createIntent", "Landroid/content/Intent;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "Companion", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class StartIntentSenderForResult extends ActivityResultContract<IntentSenderRequest, ActivityResult> {
        public static final String ACTION_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.action.INTENT_SENDER_REQUEST";
        public static final Companion Companion = null;
        public static final String EXTRA_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST";
        public static final String EXTRA_SEND_INTENT_EXCEPTION = "androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION";

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$StartIntentSenderForResult$Companion;", "", "()V", "ACTION_INTENT_SENDER_REQUEST", "", "EXTRA_INTENT_SENDER_REQUEST", "EXTRA_SEND_INTENT_EXCEPTION", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public StartIntentSenderForResult() {
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r100, IntentSenderRequest r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "input");
            return new Intent(ACTION_INTENT_SENDER_REQUEST).putExtra(EXTRA_INTENT_SENDER_REQUEST, r101);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public ActivityResult parseResult(int r100, Intent r101) {
            return new ActivityResult(r100, r101);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r100, IntentSenderRequest r101) {
            return createIntent2(r100, r101);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResult parseResult(int r100, Intent r101) {
            return parseResult(r100, r101);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0017J\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002J\u001d\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$TakePicture;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "", "()V", "createIntent", "Landroid/content/Intent;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "(ILandroid/content/Intent;)Ljava/lang/Boolean;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class TakePicture extends ActivityResultContract<Uri, Boolean> {
        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult2(Context r100, Uri r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "input");
            return null;
        }

        public TakePicture() {
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r100, Uri r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "input");
            return new Intent("android.media.action.IMAGE_CAPTURE").putExtra(BdpAppEventConstant.PARAMS_OUTPUT, r101);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(Context r100, Uri r101) {
            return getSynchronousResult2(r100, r101);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Boolean parseResult(int r100, Intent r101) {
            if (r100 != (-1)) goto L5;
            boolean r102 = true;
        L7:
            return Boolean.valueOf(r102);
        L5:
            r102 = false;
            goto L7
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r100, Uri r101) {
            return createIntent2(r100, r101);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Boolean parseResult(int r100, Intent r101) {
            return parseResult(r100, r101);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0017J\"\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006¨\u0006\u0010"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$TakePicturePreview;", "Landroidx/activity/result/contract/ActivityResultContract;", "Ljava/lang/Void;", "Landroid/graphics/Bitmap;", "()V", "createIntent", "Landroid/content/Intent;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class TakePicturePreview extends ActivityResultContract<Void, Bitmap> {
        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult2(Context r100, Void r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return null;
        }

        public TakePicturePreview() {
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r100, Void r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new Intent("android.media.action.IMAGE_CAPTURE");
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(Context r100, Void r101) {
            return getSynchronousResult2(r100, r101);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Bitmap parseResult(int r100, Intent r101) {
            if (r100 != (-1)) goto L5;
            boolean r102 = true;
        L7:
            if (r102 == true) goto L10;
            r101 = null;
        L10:
            if (r101 != null) goto L12;
            return null;
        L12:
            return (Bitmap) r101.getParcelableExtra("data");
        L5:
            r102 = false;
            goto L7
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r100, Void r101) {
            return createIntent2(r100, r101);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Bitmap parseResult(int r100, Intent r101) {
            return parseResult(r100, r101);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0017\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0017J \u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006¨\u0006\u0010"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$TakeVideo;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "Landroid/graphics/Bitmap;", "()V", "createIntent", "Landroid/content/Intent;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Deprecated(message = "The thumbnail bitmap is rarely returned and is not a good signal to determine\n      whether the video was actually successfully captured. Use {@link CaptureVideo} instead.")
    public static class TakeVideo extends ActivityResultContract<Uri, Bitmap> {
        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult2(Context r100, Uri r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "input");
            return null;
        }

        public TakeVideo() {
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r100, Uri r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "input");
            return new Intent("android.media.action.VIDEO_CAPTURE").putExtra(BdpAppEventConstant.PARAMS_OUTPUT, r101);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(Context r100, Uri r101) {
            return getSynchronousResult2(r100, r101);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Bitmap parseResult(int r100, Intent r101) {
            if (r100 != (-1)) goto L5;
            boolean r102 = true;
        L7:
            if (r102 == true) goto L10;
            r101 = null;
        L10:
            if (r101 != null) goto L12;
            return null;
        L12:
            return (Bitmap) r101.getParcelableExtra("data");
        L5:
            r102 = false;
            goto L7
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r100, Uri r101) {
            return createIntent2(r100, r101);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Bitmap parseResult(int r100, Intent r101) {
            return parseResult(r100, r101);
        }
    }

    private ActivityResultContracts() {
    }
}
