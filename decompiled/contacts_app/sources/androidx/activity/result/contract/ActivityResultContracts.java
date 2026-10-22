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
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
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

/* JADX INFO: compiled from: ActivityResultContracts.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\u0018\u00002\u00020\u0001:\u0011\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0014"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts;", "", "()V", "CaptureVideo", "CreateDocument", "GetContent", "GetMultipleContents", "OpenDocument", "OpenDocumentTree", "OpenMultipleDocuments", "PickContact", "PickMultipleVisualMedia", "PickVisualMedia", "RequestMultiplePermissions", "RequestPermission", "StartActivityForResult", "StartIntentSenderForResult", "TakePicture", "TakePicturePreview", "TakeVideo", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ActivityResultContracts {

    /* JADX INFO: compiled from: ActivityResultContracts.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0017J\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002J\u001d\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$CaptureVideo;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", MemorySourceLinkType.INTENT, "(ILandroid/content/Intent;)Ljava/lang/Boolean;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class CaptureVideo extends ActivityResultContract<Uri, Boolean> {
        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult2(Context r1, Uri r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "input");
            return null;
        }

        public CaptureVideo() {
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r1, Uri r2) {
            return createIntent2(r1, r2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(Context r1, Uri r2) {
            return getSynchronousResult2(r1, r2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Boolean parseResult(int r1, Intent r2) {
            return parseResult(r1, r2);
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r1, Uri r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "input");
            Intent r0 = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", r2);
            Intrinsics.checkNotNullExpressionValue(r0, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return r0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Boolean parseResult(int r1, Intent r2) {
            if (r1 != (-1)) goto L5;
            boolean r0 = true;
        L7:
            return Boolean.valueOf(r0);
        L5:
            r0 = false;
            goto L7
        }
    }

    /* JADX INFO: compiled from: ActivityResultContracts.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0017\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007\b\u0017¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0017J \u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0005\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$CreateDocument;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "Landroid/net/Uri;", "()V", "mimeType", "(Ljava/lang/String;)V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", MemorySourceLinkType.INTENT, "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class CreateDocument extends ActivityResultContract<String, Uri> {
        private final String mimeType;

        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult2(Context r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r1, String r2) {
            return createIntent2(r1, r2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context r1, String r2) {
            return getSynchronousResult2(r1, r2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Uri parseResult(int r1, Intent r2) {
            return parseResult(r1, r2);
        }

        public CreateDocument(String r2) {
            Intrinsics.checkNotNullParameter(r2, "mimeType");
            this.mimeType = r2;
        }

        @Deprecated(message = "Using a wildcard mime type with CreateDocument is not recommended as it breaks the automatic handling of file extensions. Instead, specify the mime type by using the constructor that takes an concrete mime type (e.g.., CreateDocument(\"image/png\")).", replaceWith = @ReplaceWith(expression = "CreateDocument(\"todo/todo\")", imports = {}))
        public CreateDocument() {
            this("*/*");
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "input");
            Intent r1 = new Intent("android.intent.action.CREATE_DOCUMENT").setType(this.mimeType).putExtra("android.intent.extra.TITLE", r3);
            Intrinsics.checkNotNullExpressionValue(r1, "Intent(Intent.ACTION_CRE…ntent.EXTRA_TITLE, input)");
            return r1;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Uri parseResult(int r1, Intent r2) {
            if (r1 != (-1)) goto L5;
            boolean r0 = true;
        L7:
            if (r0 == true) goto L10;
            r2 = null;
        L10:
            if (r2 != null) goto L12;
            return null;
        L12:
            return r2.getData();
        L5:
            r0 = false;
            goto L7
        }
    }

    /* JADX INFO: compiled from: ActivityResultContracts.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0017J \u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006¨\u0006\u0010"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$GetContent;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "Landroid/net/Uri;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", MemorySourceLinkType.INTENT, "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class GetContent extends ActivityResultContract<String, Uri> {
        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult2(Context r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "input");
            return null;
        }

        public GetContent() {
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r1, String r2) {
            return createIntent2(r1, r2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context r1, String r2) {
            return getSynchronousResult2(r1, r2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Uri parseResult(int r1, Intent r2) {
            return parseResult(r1, r2);
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "input");
            Intent r0 = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(r2);
            Intrinsics.checkNotNullExpressionValue(r0, "Intent(Intent.ACTION_GET…          .setType(input)");
            return r0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Uri parseResult(int r1, Intent r2) {
            if (r1 != (-1)) goto L5;
            boolean r0 = true;
        L7:
            if (r0 == true) goto L10;
            r2 = null;
        L10:
            if (r2 != null) goto L12;
            return null;
        L12:
            return r2.getData();
        L5:
            r0 = false;
            goto L7
        }
    }

    /* JADX INFO: compiled from: ActivityResultContracts.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0017\u0018\u0000 \u00122\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u00030\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0017J$\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002J\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\b¨\u0006\u0013"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$GetMultipleContents;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "Landroid/net/Uri;", "Lkotlin/jvm/JvmSuppressWildcards;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", MemorySourceLinkType.INTENT, "Companion", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class GetMultipleContents extends ActivityResultContract<String, List<Uri>> {
        public static final Companion Companion = null;

        /* JADX INFO: compiled from: ActivityResultContracts.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$GetMultipleContents$Companion;", "", "()V", "getClipDataUris", "", "Landroid/net/Uri;", "Landroid/content/Intent;", "getClipDataUris$activity_release", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            private Companion() {
            }

            public final List<Uri> getClipDataUris$activity_release(Intent r4) {
                Intrinsics.checkNotNullParameter(r4, "<this>");
                LinkedHashSet r3 = new LinkedHashSet();
                Uri r0 = r4.getData();
                if (r0 == null) goto L5;
                r3.add(r0);
            L5:
                ClipData r5 = r4.getClipData();
                if (r5 == null) goto L8;
            L11:
                if (r5 == null) goto L19;
                int r1 = r5.getItemCount();
                int r2 = 0;
            L13:
                if (r2 >= r1) goto L19;
                Uri r6 = r5.getItemAt(r2).getUri();
                if (r6 == null) goto L17;
                r3.add(r6);
            L17:
                r2 = r2 + 1;
            L19:
                return new ArrayList(r3);
            L8:
                if (r3.isEmpty() == false) goto L11;
                return CollectionsKt.emptyList();
            }
        }

        static {
            Companion = new Companion(null);
        }

        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult2(Context r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r1, String r2) {
            return createIntent2(r1, r2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(Context r1, String r2) {
            return getSynchronousResult2(r1, r2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ List<Uri> parseResult(int r1, Intent r2) {
            return parseResult2(r1, r2);
        }

        public GetMultipleContents() {
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "input");
            Intent r0 = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(r2).putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            Intrinsics.checkNotNullExpressionValue(r0, "Intent(Intent.ACTION_GET…TRA_ALLOW_MULTIPLE, true)");
            return r0;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: parseResult, reason: avoid collision after fix types in other method */
        public final List<Uri> parseResult2(int r1, Intent r2) {
            if (r1 != (-1)) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == true) goto L9;
            r2 = null;
        L9:
            if (r2 == null) goto L14;
            List<Uri> r3 = Companion.getClipDataUris$activity_release(r2);
            if (r3 == null) goto L14;
            return r3;
        L14:
            return CollectionsKt.emptyList();
        L5:
            r0 = false;
            goto L6
        }
    }

    /* JADX INFO: compiled from: ActivityResultContracts.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0017\u0018\u00002\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001B\u0005¢\u0006\u0002\u0010\u0005J#\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0017¢\u0006\u0002\u0010\u000bJ+\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\u0010\u000eJ\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007¨\u0006\u0013"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$OpenDocument;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "Landroid/net/Uri;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "(Landroid/content/Context;[Ljava/lang/String;)Landroid/content/Intent;", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "(Landroid/content/Context;[Ljava/lang/String;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", MemorySourceLinkType.INTENT, "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class OpenDocument extends ActivityResultContract<String[], Uri> {
        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult2(Context r1, String[] r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r1, String[] r2) {
            return createIntent2(r1, r2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context r1, String[] r2) {
            return getSynchronousResult2(r1, r2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Uri parseResult(int r1, Intent r2) {
            return parseResult(r1, r2);
        }

        public OpenDocument() {
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r1, String[] r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "input");
            Intent r0 = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", r2).setType("*/*");
            Intrinsics.checkNotNullExpressionValue(r0, "Intent(Intent.ACTION_OPE…          .setType(\"*/*\")");
            return r0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Uri parseResult(int r1, Intent r2) {
            if (r1 != (-1)) goto L5;
            boolean r0 = true;
        L7:
            if (r0 == true) goto L10;
            r2 = null;
        L10:
            if (r2 != null) goto L12;
            return null;
        L12:
            return r2.getData();
        L5:
            r0 = false;
            goto L7
        }
    }

    /* JADX INFO: compiled from: ActivityResultContracts.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0017\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0017J\"\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005¨\u0006\u000f"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$OpenDocumentTree;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", MemorySourceLinkType.INTENT, "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class OpenDocumentTree extends ActivityResultContract<Uri, Uri> {
        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult2(Context r1, Uri r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r1, Uri r2) {
            return createIntent2(r1, r2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context r1, Uri r2) {
            return getSynchronousResult2(r1, r2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Uri parseResult(int r1, Intent r2) {
            return parseResult(r1, r2);
        }

        public OpenDocumentTree() {
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r1, Uri r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intent r0 = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            if (r2 == null) goto L5;
            r0.putExtra("android.provider.extra.INITIAL_URI", r2);
        L5:
            return r0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Uri parseResult(int r1, Intent r2) {
            if (r1 != (-1)) goto L5;
            boolean r0 = true;
        L7:
            if (r0 == true) goto L10;
            r2 = null;
        L10:
            if (r2 != null) goto L12;
            return null;
        L12:
            return r2.getData();
        L5:
            r0 = false;
            goto L7
        }
    }

    /* JADX INFO: compiled from: ActivityResultContracts.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0017\u0018\u00002\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0005¢\u0006\u0002\b\u00060\u00040\u0001B\u0005¢\u0006\u0002\u0010\u0007J#\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0017¢\u0006\u0002\u0010\rJ/\u0010\u000e\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\u0010\u0010J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\t¨\u0006\u0015"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$OpenMultipleDocuments;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "", "Landroid/net/Uri;", "Lkotlin/jvm/JvmSuppressWildcards;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "(Landroid/content/Context;[Ljava/lang/String;)Landroid/content/Intent;", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "(Landroid/content/Context;[Ljava/lang/String;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", MemorySourceLinkType.INTENT, "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class OpenMultipleDocuments extends ActivityResultContract<String[], List<Uri>> {
        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult2(Context r1, String[] r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r1, String[] r2) {
            return createIntent2(r1, r2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(Context r1, String[] r2) {
            return getSynchronousResult2(r1, r2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ List<Uri> parseResult(int r1, Intent r2) {
            return parseResult2(r1, r2);
        }

        public OpenMultipleDocuments() {
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r1, String[] r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "input");
            Intent r0 = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", r2).putExtra("android.intent.extra.ALLOW_MULTIPLE", true).setType("*/*");
            Intrinsics.checkNotNullExpressionValue(r0, "Intent(Intent.ACTION_OPE…          .setType(\"*/*\")");
            return r0;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: parseResult, reason: avoid collision after fix types in other method */
        public final List<Uri> parseResult2(int r1, Intent r2) {
            if (r1 != (-1)) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == true) goto L9;
            r2 = null;
        L9:
            if (r2 == null) goto L14;
            List<Uri> r3 = GetMultipleContents.Companion.getClipDataUris$activity_release(r2);
            if (r3 == null) goto L14;
            return r3;
        L14:
            return CollectionsKt.emptyList();
        L5:
            r0 = false;
            goto L6
        }
    }

    /* JADX INFO: compiled from: ActivityResultContracts.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u000e"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickContact;", "Landroidx/activity/result/contract/ActivityResultContract;", "Ljava/lang/Void;", "Landroid/net/Uri;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", MemorySourceLinkType.INTENT, "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PickContact extends ActivityResultContract<Void, Uri> {
        public PickContact() {
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r1, Void r2) {
            return createIntent2(r1, r2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Uri parseResult(int r1, Intent r2) {
            return parseResult(r1, r2);
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r1, Void r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intent r0 = new Intent("android.intent.action.PICK").setType("vnd.android.cursor.dir/contact");
            Intrinsics.checkNotNullExpressionValue(r0, "Intent(Intent.ACTION_PIC…ct.Contacts.CONTENT_TYPE)");
            return r0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public Uri parseResult(int r1, Intent r2) {
            if (r1 != (-1)) goto L5;
            boolean r0 = true;
        L7:
            if (r0 == true) goto L10;
            r2 = null;
        L10:
            if (r2 != null) goto L12;
            return null;
        L12:
            return r2.getData();
        L5:
            r0 = false;
            goto L7
        }
    }

    /* JADX INFO: compiled from: ActivityResultContracts.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000 \u00132\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u00030\u0001:\u0001\u0013B\u000f\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0017J)\u0010\u000e\u001a\u0015\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u0003\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickMultipleVisualMedia;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroidx/activity/result/PickVisualMediaRequest;", "", "Landroid/net/Uri;", "Lkotlin/jvm/JvmSuppressWildcards;", "maxItems", "", "(I)V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", MemorySourceLinkType.INTENT, "Companion", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class PickMultipleVisualMedia extends ActivityResultContract<PickVisualMediaRequest, List<Uri>> {
        public static final Companion Companion = null;
        private final int maxItems;

        /* JADX INFO: compiled from: ActivityResultContracts.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u00020\u0004H\u0001¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickMultipleVisualMedia$Companion;", "", "()V", "getMaxItems", "", "getMaxItems$activity_release", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            private Companion() {
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
            int r2 = 0;
            this(r2, 1, null);
        }

        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult2(Context r1, PickVisualMediaRequest r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r1, PickVisualMediaRequest r2) {
            return createIntent2(r1, r2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(Context r1, PickVisualMediaRequest r2) {
            return getSynchronousResult2(r1, r2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ List<Uri> parseResult(int r1, Intent r2) {
            return parseResult2(r1, r2);
        }

        public /* synthetic */ PickMultipleVisualMedia(int r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = Companion.getMaxItems$activity_release();
        L5:
            this(r1);
        }

        public PickMultipleVisualMedia(int r1) {
            this.maxItems = r1;
            boolean r0 = true;
            if (r1 > 1) goto L6;
            r0 = false;
        L6:
            if (r0 == false) goto L9;
            return;
        L9:
            throw new IllegalArgumentException("Max items must be higher than 1".toString());
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r5, PickVisualMediaRequest r6) {
            Intrinsics.checkNotNullParameter(r5, "context");
            Intrinsics.checkNotNullParameter(r6, "input");
            boolean r1 = true;
            if (PickVisualMedia.Companion.isSystemPickerAvailable$activity_release() == false) goto L13;
            Intent r7 = new Intent("android.provider.action.PICK_IMAGES");
            r7.setType(PickVisualMedia.Companion.getVisualMimeType$activity_release(r6.getMediaType()));
            if (this.maxItems <= MediaStore.getPickImagesMaxLimit()) goto L8;
            r1 = false;
        L8:
            if (r1 == false) goto L11;
            r7.putExtra("android.provider.extra.PICK_IMAGES_MAX", this.maxItems);
            return r7;
        L11:
            throw new IllegalArgumentException("Max items must be less or equals MediaStore.getPickImagesMaxLimit()".toString());
        L13:
            if (PickVisualMedia.Companion.isSystemFallbackPickerAvailable$activity_release(r5) == false) goto L20;
            ResolveInfo r8 = PickVisualMedia.Companion.getSystemFallbackPicker$activity_release(r5);
            if (r8 == null) goto L18;
            ActivityInfo r9 = r8.activityInfo;
            Intent r0 = new Intent(PickVisualMedia.ACTION_SYSTEM_FALLBACK_PICK_IMAGES);
            r0.setClassName(r9.applicationInfo.packageName, r9.name);
            r0.setType(PickVisualMedia.Companion.getVisualMimeType$activity_release(r6.getMediaType()));
            r0.putExtra(PickVisualMedia.GMS_EXTRA_PICK_IMAGES_MAX, this.maxItems);
            return r0;
        L18:
            throw new IllegalStateException("Required value was null.".toString());
        L20:
            if (PickVisualMedia.Companion.isGmsPickerAvailable$activity_release(r5) == false) goto L26;
            ResolveInfo r10 = PickVisualMedia.Companion.getGmsPicker$activity_release(r5);
            if (r10 == null) goto L25;
            ActivityInfo r11 = r10.activityInfo;
            Intent r12 = new Intent(PickVisualMedia.GMS_ACTION_PICK_IMAGES);
            r12.setClassName(r11.applicationInfo.packageName, r11.name);
            r12.putExtra(PickVisualMedia.GMS_EXTRA_PICK_IMAGES_MAX, this.maxItems);
            return r12;
        L25:
            throw new IllegalStateException("Required value was null.".toString());
        L26:
            Intent r13 = new Intent("android.intent.action.OPEN_DOCUMENT");
            r13.setType(PickVisualMedia.Companion.getVisualMimeType$activity_release(r6.getMediaType()));
            r13.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            if (r13.getType() != null) goto L33;
            r13.setType("*/*");
            r13.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
            return r13;
        L33:
            return r13;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: parseResult, reason: avoid collision after fix types in other method */
        public final List<Uri> parseResult2(int r1, Intent r2) {
            if (r1 != (-1)) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == true) goto L9;
            r2 = null;
        L9:
            if (r2 == null) goto L14;
            List<Uri> r3 = GetMultipleContents.Companion.getClipDataUris$activity_release(r2);
            if (r3 == null) goto L14;
            return r3;
        L14:
            return CollectionsKt.emptyList();
        L5:
            r0 = false;
            goto L6
        }
    }

    /* JADX INFO: compiled from: ActivityResultContracts.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0017\u0018\u0000 \u00102\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0006\u0010\u0011\u0012\u0013\u0014\u0015B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0017J \u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006¨\u0006\u0016"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroidx/activity/result/PickVisualMediaRequest;", "Landroid/net/Uri;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", MemorySourceLinkType.INTENT, "Companion", "ImageAndVideo", "ImageOnly", "SingleMimeType", "VideoOnly", "VisualMediaType", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class PickVisualMedia extends ActivityResultContract<PickVisualMediaRequest, Uri> {
        public static final String ACTION_SYSTEM_FALLBACK_PICK_IMAGES = "androidx.activity.result.contract.action.PICK_IMAGES";
        public static final Companion Companion = null;
        public static final String EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_MAX = "androidx.activity.result.contract.extra.PICK_IMAGES_MAX";
        public static final String GMS_ACTION_PICK_IMAGES = "com.google.android.gms.provider.action.PICK_IMAGES";
        public static final String GMS_EXTRA_PICK_IMAGES_MAX = "com.google.android.gms.provider.extra.PICK_IMAGES_MAX";

        /* JADX INFO: compiled from: ActivityResultContracts.kt */
        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0001¢\u0006\u0002\b\u000eJ\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0001¢\u0006\u0002\b\u0010J\u0017\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0014J\u0015\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\rH\u0001¢\u0006\u0002\b\u0017J\b\u0010\u0018\u001a\u00020\u0016H\u0007J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\rH\u0007J\u0015\u0010\u0019\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\rH\u0001¢\u0006\u0002\b\u001aJ\r\u0010\u001b\u001a\u00020\u0016H\u0001¢\u0006\u0002\b\u001cR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0014\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u000e\u0010\b\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$Companion;", "", "()V", "ACTION_SYSTEM_FALLBACK_PICK_IMAGES", "", "getACTION_SYSTEM_FALLBACK_PICK_IMAGES$annotations", "EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_MAX", "getEXTRA_SYSTEM_FALLBACK_PICK_IMAGES_MAX$annotations", "GMS_ACTION_PICK_IMAGES", "GMS_EXTRA_PICK_IMAGES_MAX", "getGmsPicker", "Landroid/content/pm/ResolveInfo;", "context", "Landroid/content/Context;", "getGmsPicker$activity_release", "getSystemFallbackPicker", "getSystemFallbackPicker$activity_release", "getVisualMimeType", "input", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "getVisualMimeType$activity_release", "isGmsPickerAvailable", "", "isGmsPickerAvailable$activity_release", "isPhotoPickerAvailable", "isSystemFallbackPickerAvailable", "isSystemFallbackPickerAvailable$activity_release", "isSystemPickerAvailable", "isSystemPickerAvailable$activity_release", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            public static /* synthetic */ void getACTION_SYSTEM_FALLBACK_PICK_IMAGES$annotations() {
            }

            public static /* synthetic */ void getEXTRA_SYSTEM_FALLBACK_PICK_IMAGES_MAX$annotations() {
            }

            private Companion() {
            }

            @Deprecated(message = "This method is deprecated in favor of isPhotoPickerAvailable(context) to support the picker provided by updatable system apps", replaceWith = @ReplaceWith(expression = "isPhotoPickerAvailable(context)", imports = {}))
            @JvmStatic
            public final boolean isPhotoPickerAvailable() {
                return isSystemPickerAvailable$activity_release();
            }

            @JvmStatic
            public final boolean isPhotoPickerAvailable(Context r2) {
                Intrinsics.checkNotNullParameter(r2, "context");
                if (isSystemPickerAvailable$activity_release() == false) goto L5;
            L10:
                return true;
            L5:
                if (isSystemFallbackPickerAvailable$activity_release(r2) == true) goto L10;
                if (isGmsPickerAvailable$activity_release(r2) == true) goto L10;
                return false;
            }

            @JvmStatic
            public final boolean isSystemPickerAvailable$activity_release() {
                if (Build.VERSION.SDK_INT < 33) goto L6;
                return true;
            L6:
                if (SdkExtensions.getExtensionVersion(30) >= 2) goto L11;
                return false;
            L11:
                return true;
            }

            @JvmStatic
            public final boolean isSystemFallbackPickerAvailable$activity_release(Context r2) {
                Intrinsics.checkNotNullParameter(r2, "context");
                if (getSystemFallbackPicker$activity_release(r2) == null) goto L5;
                return true;
            L5:
                return false;
            }

            @JvmStatic
            public final ResolveInfo getSystemFallbackPicker$activity_release(Context r2) {
                Intrinsics.checkNotNullParameter(r2, "context");
                return r2.getPackageManager().resolveActivity(new Intent(PickVisualMedia.ACTION_SYSTEM_FALLBACK_PICK_IMAGES), 1114112);
            }

            @JvmStatic
            public final boolean isGmsPickerAvailable$activity_release(Context r2) {
                Intrinsics.checkNotNullParameter(r2, "context");
                if (getGmsPicker$activity_release(r2) == null) goto L5;
                return true;
            L5:
                return false;
            }

            @JvmStatic
            public final ResolveInfo getGmsPicker$activity_release(Context r2) {
                Intrinsics.checkNotNullParameter(r2, "context");
                return r2.getPackageManager().resolveActivity(new Intent(PickVisualMedia.GMS_ACTION_PICK_IMAGES), 1114112);
            }

            public final String getVisualMimeType$activity_release(VisualMediaType r1) {
                Intrinsics.checkNotNullParameter(r1, "input");
                if ((r1 instanceof ImageOnly) == false) goto L6;
                return "image/*";
            L6:
                if ((r1 instanceof VideoOnly) == false) goto L9;
                return "video/*";
            L9:
                if ((r1 instanceof SingleMimeType) == false) goto L12;
                return ((SingleMimeType) r1).getMimeType();
            L12:
                if ((r1 instanceof ImageAndVideo) == false) goto L16;
                return null;
            L16:
                throw new NoWhenBranchMatchedException();
            }
        }

        /* JADX INFO: compiled from: ActivityResultContracts.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$ImageAndVideo;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "()V", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class ImageAndVideo implements VisualMediaType {
            public static final ImageAndVideo INSTANCE = null;

            static {
                INSTANCE = new ImageAndVideo();
            }

            private ImageAndVideo() {
            }
        }

        /* JADX INFO: compiled from: ActivityResultContracts.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$ImageOnly;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "()V", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class ImageOnly implements VisualMediaType {
            public static final ImageOnly INSTANCE = null;

            static {
                INSTANCE = new ImageOnly();
            }

            private ImageOnly() {
            }
        }

        /* JADX INFO: compiled from: ActivityResultContracts.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$SingleMimeType;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "mimeType", "", "(Ljava/lang/String;)V", "getMimeType", "()Ljava/lang/String;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class SingleMimeType implements VisualMediaType {
            private final String mimeType;

            public SingleMimeType(String r2) {
                Intrinsics.checkNotNullParameter(r2, "mimeType");
                this.mimeType = r2;
            }

            public final String getMimeType() {
                return this.mimeType;
            }
        }

        /* JADX INFO: compiled from: ActivityResultContracts.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VideoOnly;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "()V", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class VideoOnly implements VisualMediaType {
            public static final VideoOnly INSTANCE = null;

            static {
                INSTANCE = new VideoOnly();
            }

            private VideoOnly() {
            }
        }

        /* JADX INFO: compiled from: ActivityResultContracts.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001\u0082\u0001\u0004\u0002\u0003\u0004\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$ImageAndVideo;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$ImageOnly;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$SingleMimeType;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VideoOnly;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public interface VisualMediaType {
        }

        static {
            Companion = new Companion(null);
        }

        @JvmStatic
        public static final ResolveInfo getGmsPicker$activity_release(Context r1) {
            return Companion.getGmsPicker$activity_release(r1);
        }

        @JvmStatic
        public static final ResolveInfo getSystemFallbackPicker$activity_release(Context r1) {
            return Companion.getSystemFallbackPicker$activity_release(r1);
        }

        @JvmStatic
        public static final boolean isGmsPickerAvailable$activity_release(Context r1) {
            return Companion.isGmsPickerAvailable$activity_release(r1);
        }

        @Deprecated(message = "This method is deprecated in favor of isPhotoPickerAvailable(context) to support the picker provided by updatable system apps", replaceWith = @ReplaceWith(expression = "isPhotoPickerAvailable(context)", imports = {}))
        @JvmStatic
        public static final boolean isPhotoPickerAvailable() {
            return Companion.isPhotoPickerAvailable();
        }

        @JvmStatic
        public static final boolean isPhotoPickerAvailable(Context r1) {
            return Companion.isPhotoPickerAvailable(r1);
        }

        @JvmStatic
        public static final boolean isSystemFallbackPickerAvailable$activity_release(Context r1) {
            return Companion.isSystemFallbackPickerAvailable$activity_release(r1);
        }

        @JvmStatic
        public static final boolean isSystemPickerAvailable$activity_release() {
            return Companion.isSystemPickerAvailable$activity_release();
        }

        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult2(Context r1, PickVisualMediaRequest r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r1, PickVisualMediaRequest r2) {
            return createIntent2(r1, r2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context r1, PickVisualMediaRequest r2) {
            return getSynchronousResult2(r1, r2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Uri parseResult(int r1, Intent r2) {
            return parseResult(r1, r2);
        }

        public PickVisualMedia() {
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r3, PickVisualMediaRequest r4) {
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r4, "input");
            Companion r2 = Companion;
            if (r2.isSystemPickerAvailable$activity_release() == false) goto L6;
            Intent r5 = new Intent("android.provider.action.PICK_IMAGES");
            r5.setType(r2.getVisualMimeType$activity_release(r4.getMediaType()));
            return r5;
        L6:
            if (r2.isSystemFallbackPickerAvailable$activity_release(r3) == false) goto L14;
            ResolveInfo r6 = r2.getSystemFallbackPicker$activity_release(r3);
            if (r6 == null) goto L12;
            ActivityInfo r7 = r6.activityInfo;
            Intent r0 = new Intent(ACTION_SYSTEM_FALLBACK_PICK_IMAGES);
            r0.setClassName(r7.applicationInfo.packageName, r7.name);
            r0.setType(r2.getVisualMimeType$activity_release(r4.getMediaType()));
        L25:
            return r0;
        L12:
            throw new IllegalStateException("Required value was null.".toString());
        L14:
            if (r2.isGmsPickerAvailable$activity_release(r3) == false) goto L20;
            ResolveInfo r8 = r2.getGmsPicker$activity_release(r3);
            if (r8 == null) goto L19;
            ActivityInfo r9 = r8.activityInfo;
            r0 = new Intent(GMS_ACTION_PICK_IMAGES);
            r0.setClassName(r9.applicationInfo.packageName, r9.name);
            r0.setType(r2.getVisualMimeType$activity_release(r4.getMediaType()));
            goto L25
        L19:
            throw new IllegalStateException("Required value was null.".toString());
        L20:
            Intent r10 = new Intent("android.intent.action.OPEN_DOCUMENT");
            r10.setType(r2.getVisualMimeType$activity_release(r4.getMediaType()));
            if (r10.getType() != null) goto L26;
            r10.setType("*/*");
            r10.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
            return r10;
        L26:
            return r10;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Uri parseResult(int r1, Intent r2) {
            if (r1 != (-1)) goto L5;
            boolean r0 = true;
        L7:
            if (r0 == true) goto L10;
            r2 = null;
        L10:
            if (r2 == null) goto L16;
            Uri r3 = r2.getData();
            if (r3 != null) goto L15;
            r3 = (Uri) CollectionsKt.firstOrNull(GetMultipleContents.Companion.getClipDataUris$activity_release(r2));
        L15:
            return r3;
        L16:
            return null;
        L5:
            r0 = false;
            goto L7
        }
    }

    /* JADX INFO: compiled from: ActivityResultContracts.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00152%\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0003\u0012\t\u0012\u00070\u0005¢\u0006\u0002\b\u00060\u00040\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0007J#\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0002\u0010\rJ7\u0010\u000e\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0002\u0010\u0010J&\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u0016"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$RequestMultiplePermissions;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "", "", "Lkotlin/jvm/JvmSuppressWildcards;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "(Landroid/content/Context;[Ljava/lang/String;)Landroid/content/Intent;", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "(Landroid/content/Context;[Ljava/lang/String;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", MemorySourceLinkType.INTENT, "Companion", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class RequestMultiplePermissions extends ActivityResultContract<String[], Map<String, Boolean>> {
        public static final String ACTION_REQUEST_PERMISSIONS = "androidx.activity.result.contract.action.REQUEST_PERMISSIONS";
        public static final Companion Companion = null;
        public static final String EXTRA_PERMISSIONS = "androidx.activity.result.contract.extra.PERMISSIONS";
        public static final String EXTRA_PERMISSION_GRANT_RESULTS = "androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS";

        /* JADX INFO: compiled from: ActivityResultContracts.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u0000¢\u0006\u0004\b\u000b\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$RequestMultiplePermissions$Companion;", "", "()V", "ACTION_REQUEST_PERMISSIONS", "", "EXTRA_PERMISSIONS", "EXTRA_PERMISSION_GRANT_RESULTS", "createIntent", "Landroid/content/Intent;", "input", "", "createIntent$activity_release", "([Ljava/lang/String;)Landroid/content/Intent;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            private Companion() {
            }

            public final Intent createIntent$activity_release(String[] r2) {
                Intrinsics.checkNotNullParameter(r2, "input");
                Intent r1 = new Intent(RequestMultiplePermissions.ACTION_REQUEST_PERMISSIONS).putExtra(RequestMultiplePermissions.EXTRA_PERMISSIONS, r2);
                Intrinsics.checkNotNullExpressionValue(r1, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
                return r1;
            }
        }

        static {
            Companion = new Companion(null);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r1, String[] r2) {
            return createIntent2(r1, r2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Map<String, Boolean>> getSynchronousResult(Context r1, String[] r2) {
            return getSynchronousResult2(r1, r2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Map<String, Boolean> parseResult(int r1, Intent r2) {
            return parseResult2(r1, r2);
        }

        public RequestMultiplePermissions() {
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r1, String[] r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "input");
            return Companion.createIntent$activity_release(r2);
        }

        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public ActivityResultContract.SynchronousResult<Map<String, Boolean>> getSynchronousResult2(Context r5, String[] r6) {
            Intrinsics.checkNotNullParameter(r5, "context");
            Intrinsics.checkNotNullParameter(r6, "input");
            int r0 = 0;
            if (r6.length != 0) goto L5;
            boolean r4 = true;
        L6:
            if (r4 == true) goto L8;
            int r7 = r6.length;
            int r2 = 0;
        L10:
            if (r2 >= r7) goto L18;
            if (ContextCompat.checkSelfPermission(r5, r6[r2]) != 0) goto L14;
            boolean r3 = true;
        L15:
            if (r3 == false) goto L16;
            r2 = r2 + 1;
            goto L10
        L16:
            boolean r8 = false;
        L19:
            if (r8 == false) goto L24;
            LinkedHashMap r9 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r6.length), 16));
            int r10 = r6.length;
        L21:
            if (r0 >= r10) goto L29;
            Pair r11 = TuplesKt.to(r6[r0], true);
            r9.put(r11.getFirst(), r11.getSecond());
            r0 = r0 + 1;
            goto L21
        L29:
            return new ActivityResultContract.SynchronousResult(r9);
        L24:
            return null;
        L14:
            r3 = false;
            goto L15
        L18:
            r8 = true;
            goto L19
        L8:
            return new ActivityResultContract.SynchronousResult(MapsKt.emptyMap());
        L5:
            r4 = false;
            goto L6
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: parseResult, reason: avoid collision after fix types in other method */
        public Map<String, Boolean> parseResult2(int r5, Intent r6) {
            if (r5 != (-1)) goto L5;
            if (r6 == null) goto L8;
            String[] r4 = r6.getStringArrayExtra(EXTRA_PERMISSIONS);
            int[] r7 = r6.getIntArrayExtra(EXTRA_PERMISSION_GRANT_RESULTS);
            if (r7 == null) goto L23;
            if (r4 == null) goto L23;
            ArrayList r8 = new ArrayList(r7.length);
            int r0 = r7.length;
            int r2 = 0;
        L14:
            if (r2 >= r0) goto L21;
            if (r7[r2] != 0) goto L18;
            boolean r3 = true;
        L19:
            r8.add(Boolean.valueOf(r3));
            r2 = r2 + 1;
            goto L14
        L18:
            r3 = false;
            goto L19
        L21:
            return MapsKt.toMap(CollectionsKt.zip(ArraysKt.filterNotNull(r4), r8));
        L23:
            return MapsKt.emptyMap();
        L8:
            return MapsKt.emptyMap();
        L5:
            return MapsKt.emptyMap();
        }
    }

    /* JADX INFO: compiled from: ActivityResultContracts.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J \u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001f\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$RequestPermission;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", MemorySourceLinkType.INTENT, "(ILandroid/content/Intent;)Ljava/lang/Boolean;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class RequestPermission extends ActivityResultContract<String, Boolean> {
        public RequestPermission() {
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r1, String r2) {
            return createIntent2(r1, r2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(Context r1, String r2) {
            return getSynchronousResult2(r1, r2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Boolean parseResult(int r1, Intent r2) {
            return parseResult(r1, r2);
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "input");
            return RequestMultiplePermissions.Companion.createIntent$activity_release(new String[]{r3});
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public Boolean parseResult(int r4, Intent r5) {
            boolean r3 = false;
            if (r5 == null) goto L25;
            if (r4 != (-1)) goto L25;
            int[] r6 = r5.getIntArrayExtra(RequestMultiplePermissions.EXTRA_PERMISSION_GRANT_RESULTS);
            if (r6 == null) goto L23;
            int r7 = r6.length;
            int r0 = 0;
        L11:
            if (r0 >= r7) goto L19;
            if (r6[r0] != 0) goto L15;
            boolean r2 = true;
        L16:
            if (r2 == true) goto L17;
            r0 = r0 + 1;
            goto L11
        L17:
            boolean r8 = true;
        L20:
            if (r8 != true) goto L23;
            r3 = true;
            goto L23
        L15:
            r2 = false;
            goto L16
        L19:
            r8 = false;
        L23:
            return Boolean.valueOf(r3);
        L25:
            return false;
        }

        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult2(Context r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "input");
            if (ContextCompat.checkSelfPermission(r1, r2) != 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == true) goto L10;
            return null;
        L10:
            return new ActivityResultContract.SynchronousResult(true);
        L5:
            r0 = false;
            goto L6
        }
    }

    /* JADX INFO: compiled from: ActivityResultContracts.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000e"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/content/Intent;", "Landroidx/activity/result/ActivityResult;", "()V", "createIntent", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", MemorySourceLinkType.INTENT, "Companion", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class StartActivityForResult extends ActivityResultContract<Intent, ActivityResult> {
        public static final Companion Companion = null;
        public static final String EXTRA_ACTIVITY_OPTIONS_BUNDLE = "androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE";

        /* JADX INFO: compiled from: ActivityResultContracts.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult$Companion;", "", "()V", "EXTRA_ACTIVITY_OPTIONS_BUNDLE", "", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            private Companion() {
            }
        }

        static {
            Companion = new Companion(null);
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r1, Intent r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "input");
            return r2;
        }

        public StartActivityForResult() {
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r1, Intent r2) {
            return createIntent2(r1, r2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResult parseResult(int r1, Intent r2) {
            return parseResult(r1, r2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public ActivityResult parseResult(int r1, Intent r2) {
            return new ActivityResult(r1, r2);
        }
    }

    /* JADX INFO: compiled from: ActivityResultContracts.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u000e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u000f"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$StartIntentSenderForResult;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroidx/activity/result/IntentSenderRequest;", "Landroidx/activity/result/ActivityResult;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", MemorySourceLinkType.INTENT, "Companion", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class StartIntentSenderForResult extends ActivityResultContract<IntentSenderRequest, ActivityResult> {
        public static final String ACTION_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.action.INTENT_SENDER_REQUEST";
        public static final Companion Companion = null;
        public static final String EXTRA_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST";
        public static final String EXTRA_SEND_INTENT_EXCEPTION = "androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION";

        /* JADX INFO: compiled from: ActivityResultContracts.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$StartIntentSenderForResult$Companion;", "", "()V", "ACTION_INTENT_SENDER_REQUEST", "", "EXTRA_INTENT_SENDER_REQUEST", "EXTRA_SEND_INTENT_EXCEPTION", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            private Companion() {
            }
        }

        static {
            Companion = new Companion(null);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r1, IntentSenderRequest r2) {
            return createIntent2(r1, r2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResult parseResult(int r1, Intent r2) {
            return parseResult(r1, r2);
        }

        public StartIntentSenderForResult() {
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r1, IntentSenderRequest r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "input");
            Intent r0 = new Intent(ACTION_INTENT_SENDER_REQUEST).putExtra(EXTRA_INTENT_SENDER_REQUEST, r2);
            Intrinsics.checkNotNullExpressionValue(r0, "Intent(ACTION_INTENT_SEN…NT_SENDER_REQUEST, input)");
            return r0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public ActivityResult parseResult(int r1, Intent r2) {
            return new ActivityResult(r1, r2);
        }
    }

    /* JADX INFO: compiled from: ActivityResultContracts.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0017J\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002J\u001d\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$TakePicture;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", MemorySourceLinkType.INTENT, "(ILandroid/content/Intent;)Ljava/lang/Boolean;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class TakePicture extends ActivityResultContract<Uri, Boolean> {
        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult2(Context r1, Uri r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "input");
            return null;
        }

        public TakePicture() {
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r1, Uri r2) {
            return createIntent2(r1, r2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(Context r1, Uri r2) {
            return getSynchronousResult2(r1, r2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Boolean parseResult(int r1, Intent r2) {
            return parseResult(r1, r2);
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r1, Uri r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "input");
            Intent r0 = new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", r2);
            Intrinsics.checkNotNullExpressionValue(r0, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return r0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Boolean parseResult(int r1, Intent r2) {
            if (r1 != (-1)) goto L5;
            boolean r0 = true;
        L7:
            return Boolean.valueOf(r0);
        L5:
            r0 = false;
            goto L7
        }
    }

    /* JADX INFO: compiled from: ActivityResultContracts.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0017J\"\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006¨\u0006\u0010"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$TakePicturePreview;", "Landroidx/activity/result/contract/ActivityResultContract;", "Ljava/lang/Void;", "Landroid/graphics/Bitmap;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", MemorySourceLinkType.INTENT, "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class TakePicturePreview extends ActivityResultContract<Void, Bitmap> {
        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult2(Context r1, Void r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            return null;
        }

        public TakePicturePreview() {
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r1, Void r2) {
            return createIntent2(r1, r2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(Context r1, Void r2) {
            return getSynchronousResult2(r1, r2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Bitmap parseResult(int r1, Intent r2) {
            return parseResult(r1, r2);
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r1, Void r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            return new Intent("android.media.action.IMAGE_CAPTURE");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Bitmap parseResult(int r1, Intent r2) {
            if (r1 != (-1)) goto L5;
            boolean r0 = true;
        L7:
            if (r0 == true) goto L10;
            r2 = null;
        L10:
            if (r2 != null) goto L12;
            return null;
        L12:
            return (Bitmap) r2.getParcelableExtra("data");
        L5:
            r0 = false;
            goto L7
        }
    }

    /* JADX INFO: compiled from: ActivityResultContracts.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0017\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0017J \u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006¨\u0006\u0010"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$TakeVideo;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "Landroid/graphics/Bitmap;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", MemorySourceLinkType.INTENT, "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Deprecated(message = "The thumbnail bitmap is rarely returned and is not a good signal to determine\n      whether the video was actually successfully captured. Use {@link CaptureVideo} instead.")
    public static class TakeVideo extends ActivityResultContract<Uri, Bitmap> {
        /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
        public final ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult2(Context r1, Uri r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r1, Uri r2) {
            return createIntent2(r1, r2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(Context r1, Uri r2) {
            return getSynchronousResult2(r1, r2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Bitmap parseResult(int r1, Intent r2) {
            return parseResult(r1, r2);
        }

        public TakeVideo() {
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r1, Uri r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "input");
            Intent r0 = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", r2);
            Intrinsics.checkNotNullExpressionValue(r0, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return r0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Bitmap parseResult(int r1, Intent r2) {
            if (r1 != (-1)) goto L5;
            boolean r0 = true;
        L7:
            if (r0 == true) goto L10;
            r2 = null;
        L10:
            if (r2 != null) goto L12;
            return null;
        L12:
            return (Bitmap) r2.getParcelableExtra("data");
        L5:
            r0 = false;
            goto L7
        }
    }

    private ActivityResultContracts() {
    }
}
