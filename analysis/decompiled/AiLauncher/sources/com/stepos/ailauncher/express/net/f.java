package com.stepos.ailauncher.express.net;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.express.net.AmooExpressData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/express/net/f;", "", "<init>", "()V", Const.INTENT_KEY_UMID, "c", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "Lcom/stepos/ailauncher/express/net/f$a;", "Lcom/stepos/ailauncher/express/net/f$b;", "Lcom/stepos/ailauncher/express/net/f$c;", "Lcom/stepos/ailauncher/express/net/f$d;", "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class f {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/ailauncher/express/net/f$a;", "Lcom/stepos/ailauncher/express/net/f;", "<init>", "()V", "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends f {
        public static final a INSTANCE = new a();

        public a() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/ailauncher/express/net/f$b;", "Lcom/stepos/ailauncher/express/net/f;", "<init>", "()V", "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends f {
        public static final b INSTANCE = new b();

        public b() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/ailauncher/express/net/f$c;", "Lcom/stepos/ailauncher/express/net/f;", "<init>", "()V", "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends f {
        public static final c INSTANCE = new c();

        public c() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/express/net/f$d;", "Lcom/stepos/ailauncher/express/net/f;", "", "Lcom/stepos/ailauncher/express/net/b$a;", "edited", "<init>", "(Ljava/util/List;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.express.net.f$d, reason: from toString */
    public static final /* data */ class Success extends f {
        private final List<AmooExpressData.Edited> edited;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(List<AmooExpressData.Edited> edited) {
            super(null);
            p.i(edited, "edited");
            this.edited = edited;
        }

        public final List<AmooExpressData.Edited> a() {
            return this.edited;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Success) && p.d(this.edited, ((Success) other).edited);
        }

        public int hashCode() {
            return this.edited.hashCode();
        }

        public String toString() {
            return "Success(edited=" + this.edited + ")";
        }
    }

    public /* synthetic */ f(i iVar) {
        this();
    }

    public f() {
    }
}
