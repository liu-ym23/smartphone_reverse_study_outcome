package I0;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/content/Context;", "", "fileName", "Ljava/io/File;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;", "datastore_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class a {
    public static final File a(Context context, String fileName) {
        p.i(context, "<this>");
        p.i(fileName, "fileName");
        return new File(context.getApplicationContext().getFilesDir(), p.r("datastore/", fileName));
    }
}
