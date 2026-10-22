package d5;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.stepos.core.data.FileContent;
import java.io.FileNotFoundException;

/* loaded from: classes3.dex */
public final class m {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.stepos.core.data.FileContent a(d5.m r2, java.lang.String r3) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d5.m.a(d5.m, java.lang.String):com.stepos.core.data.FileContent");
    }

    public static FileContent b(Context context, Uri uri, String str) throws FileNotFoundException {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(uri, "uri");
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
        if (parcelFileDescriptorOpenFileDescriptor == null) {
            throw new IllegalArgumentException(B7.a.j("Cannot open URI: ", uri));
        }
        if (str == null && (str = context.getContentResolver().getType(uri)) == null) {
            str = "application/octet-stream";
        }
        String string = uri.toString();
        kotlin.jvm.internal.k.e(string, "toString(...)");
        return new FileContent(string, str, parcelFileDescriptorOpenFileDescriptor);
    }
}
