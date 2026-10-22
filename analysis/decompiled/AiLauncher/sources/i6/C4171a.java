package i6;

import M5.b;
import Xa.d;
import Xa.j;
import Xa.o;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.sheet.relay.ActivityResultRelayActivity;
import com.stepos.ailauncher.taskstore.provider.c;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ)\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Li6/a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "target", "", "c", "(Landroid/content/Context;Landroid/content/Intent;)Ljava/lang/String;", b.CREDENTIAL_TOKEN, "", "resultCode", "data", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;ILandroid/content/Intent;)V", "TAG", "Ljava/lang/String;", "LXa/j;", "Li6/a$a;", "_results", "LXa/j;", "LXa/o;", "results", "LXa/o;", Const.INTENT_KEY_PKGNAME, "()LXa/o;", "", c.a.COL_SEQ, "J", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: i6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C4171a {
    public static final C4171a INSTANCE = new C4171a();
    private static final String TAG = "ActivityResultRelay";
    private static final j<RelayResult> _results;
    private static final o<RelayResult> results;
    private static long seq;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Li6/a$a;", "", "", b.CREDENTIAL_TOKEN, "", "resultCode", "Landroid/content/Intent;", "data", "<init>", "(Ljava/lang/String;ILandroid/content/Intent;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", "I", Const.INTENT_KEY_PKGNAME, "Landroid/content/Intent;", Const.INTENT_KEY_APIKEY, "()Landroid/content/Intent;", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: i6.a$a, reason: collision with other inner class name and from toString */
    public static final /* data */ class RelayResult {
        private final Intent data;
        private final int resultCode;
        private final String token;

        public RelayResult(String token, int i10, Intent intent) {
            p.i(token, "token");
            this.token = token;
            this.resultCode = i10;
            this.data = intent;
        }

        /* renamed from: a, reason: from getter */
        public final Intent getData() {
            return this.data;
        }

        /* renamed from: b, reason: from getter */
        public final int getResultCode() {
            return this.resultCode;
        }

        /* renamed from: c, reason: from getter */
        public final String getToken() {
            return this.token;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RelayResult)) {
                return false;
            }
            RelayResult relayResult = (RelayResult) other;
            return p.d(this.token, relayResult.token) && this.resultCode == relayResult.resultCode && p.d(this.data, relayResult.data);
        }

        public int hashCode() {
            int iHashCode = ((this.token.hashCode() * 31) + Integer.hashCode(this.resultCode)) * 31;
            Intent intent = this.data;
            return iHashCode + (intent == null ? 0 : intent.hashCode());
        }

        public String toString() {
            return "RelayResult(token=" + this.token + ", resultCode=" + this.resultCode + ", data=" + this.data + ")";
        }
    }

    static {
        j<RelayResult> jVarB = Xa.p.b(0, 8, null, 5, null);
        _results = jVarB;
        results = d.b(jVarB);
    }

    public static final String c(Context context, Intent target) {
        String str;
        Object objB;
        p.i(context, "context");
        p.i(target, "target");
        synchronized (INSTANCE) {
            long j10 = seq + 1;
            seq = j10;
            str = "relay_" + j10;
        }
        Intent intent = new Intent(context, (Class<?>) ActivityResultRelayActivity.class);
        intent.putExtra(ActivityResultRelayActivity.EXTRA_TOKEN, str);
        intent.putExtra(ActivityResultRelayActivity.EXTRA_TARGET, target);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.addFlags(67108864);
        intent.addFlags(8388608);
        intent.addFlags(65536);
        try {
            Result.Companion companion = Result.INSTANCE;
            context.getApplicationContext().startActivity(intent);
            objB = Result.b(str);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "start relay failed", thE);
        }
        if (Result.g(objB)) {
            objB = null;
        }
        return (String) objB;
    }

    public final void a(String token, int resultCode, Intent data) {
        p.i(token, "token");
        _results.a(new RelayResult(token, resultCode, data));
    }

    public final o<RelayResult> b() {
        return results;
    }
}
