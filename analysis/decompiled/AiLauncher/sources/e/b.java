package e;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.autonavi.aps.amapapi.config.Const;
import e.AbstractC3969a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0015¨\u0006\u0016"}, d2 = {"Le/b;", "Le/a;", "", "Landroid/net/Uri;", "mimeType", "<init>", "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "input", "Landroid/content/Intent;", Const.INTENT_KEY_UMID, "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "Le/a$a;", "e", "(Landroid/content/Context;Ljava/lang/String;)Le/a$a;", "", "resultCode", "intent", "f", "(ILandroid/content/Intent;)Landroid/net/Uri;", "Ljava/lang/String;", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public class b extends AbstractC3969a<String, Uri> {
    private final String mimeType;

    public b(String mimeType) {
        p.i(mimeType, "mimeType");
        this.mimeType = mimeType;
    }

    public Intent d(Context context, String input) {
        p.i(context, "context");
        p.i(input, "input");
        Intent intentPutExtra = new Intent("android.intent.action.CREATE_DOCUMENT").setType(this.mimeType).putExtra("android.intent.extra.TITLE", input);
        p.h(intentPutExtra, "putExtra(...)");
        return intentPutExtra;
    }

    @Override // e.AbstractC3969a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final AbstractC3969a.C0391a<Uri> b(Context context, String input) {
        p.i(context, "context");
        p.i(input, "input");
        return null;
    }

    @Override // e.AbstractC3969a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Uri c(int resultCode, Intent intent) {
        if (resultCode != -1) {
            intent = null;
        }
        if (intent != null) {
            return intent.getData();
        }
        return null;
    }
}
