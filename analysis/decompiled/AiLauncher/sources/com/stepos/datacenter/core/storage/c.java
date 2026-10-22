package com.stepos.datacenter.core.storage;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/datacenter/core/storage/c;", "", "<init>", "()V", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "Lcom/stepos/datacenter/core/storage/c$a;", "Lcom/stepos/datacenter/core/storage/c$b;", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class c {

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/datacenter/core/storage/c$a;", "Lcom/stepos/datacenter/core/storage/c;", "Lcom/stepos/datacenter/core/storage/b;", "error", "<init>", "(Lcom/stepos/datacenter/core/storage/b;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Lcom/stepos/datacenter/core/storage/b;", "()Lcom/stepos/datacenter/core/storage/b;", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.datacenter.core.storage.c$a, reason: from toString */
    public static final /* data */ class Failure extends c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final b error;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failure(b error) {
            super(null);
            p.i(error, "error");
            this.error = error;
        }

        /* renamed from: a, reason: from getter */
        public final b getError() {
            return this.error;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Failure) && p.d(this.error, ((Failure) other).error);
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "Failure(error=" + this.error + ")";
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/datacenter/core/storage/c$b;", "Lcom/stepos/datacenter/core/storage/c;", "Lcom/stepos/datacenter/core/storage/a;", "header", "<init>", "(Lcom/stepos/datacenter/core/storage/a;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Lcom/stepos/datacenter/core/storage/a;", "()Lcom/stepos/datacenter/core/storage/a;", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.datacenter.core.storage.c$b, reason: from toString */
    public static final /* data */ class Success extends c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final FileHeader header;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(FileHeader header) {
            super(null);
            p.i(header, "header");
            this.header = header;
        }

        /* renamed from: a, reason: from getter */
        public final FileHeader getHeader() {
            return this.header;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Success) && p.d(this.header, ((Success) other).header);
        }

        public int hashCode() {
            return this.header.hashCode();
        }

        public String toString() {
            return "Success(header=" + this.header + ")";
        }
    }

    public /* synthetic */ c(i iVar) {
        this();
    }

    public c() {
    }
}
