package com.bytedance.android.livesdk.interactivity.service.messagelist;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public interface IMessageListManager {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/service/messagelist/IMessageListManager$MessageChangeType;", "", "INSERT_BOTTOM", "UPDATE_BOTTOM", "REMOVE_ITEM", "UPDATE_ITEM", "INSERT_ITEM", "REMOVE_RANGE", "INIT_LIST", "RELOAD_ALL", "community-service_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum MessageChangeType extends Enum<MessageChangeType> {
        public static final MessageChangeType INIT_LIST = null;
        public static final MessageChangeType INSERT_BOTTOM = null;
        public static final MessageChangeType INSERT_ITEM = null;
        public static final MessageChangeType RELOAD_ALL = null;
        public static final MessageChangeType REMOVE_ITEM = null;
        public static final MessageChangeType REMOVE_RANGE = null;
        public static final MessageChangeType UPDATE_BOTTOM = null;
        public static final MessageChangeType UPDATE_ITEM = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MessageChangeType[] f140852a = null;

        static {
            MessageChangeType r100 = new MessageChangeType("INSERT_BOTTOM", 0);
            INSERT_BOTTOM = r100;
            MessageChangeType r101 = new MessageChangeType("UPDATE_BOTTOM", 1);
            UPDATE_BOTTOM = r101;
            MessageChangeType r102 = new MessageChangeType("REMOVE_ITEM", 2);
            REMOVE_ITEM = r102;
            MessageChangeType r103 = new MessageChangeType("UPDATE_ITEM", 3);
            UPDATE_ITEM = r103;
            MessageChangeType r104 = new MessageChangeType("INSERT_ITEM", 4);
            INSERT_ITEM = r104;
            MessageChangeType r105 = new MessageChangeType("REMOVE_RANGE", 5);
            REMOVE_RANGE = r105;
            MessageChangeType r106 = new MessageChangeType("INIT_LIST", 6);
            INIT_LIST = r106;
            MessageChangeType r107 = new MessageChangeType("RELOAD_ALL", 7);
            RELOAD_ALL = r107;
            f140852a = new MessageChangeType[]{r100, r101, r102, r103, r104, r105, r106, r107};
        }

        public static MessageChangeType valueOf(String r100) {
            return (MessageChangeType) r27.a.a(MessageChangeType.class, r100);
        }

        public static MessageChangeType[] values() {
            return (MessageChangeType[]) f140852a.clone();
        }

        public MessageChangeType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MessageChangeType f140853a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f140854b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f140855c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f140856d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final c f140857e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L16;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f140853a, r101.f140853a) == true) goto L8;
            return false;
        L8:
            if (this.f140854b == r101.f140854b) goto L10;
            return false;
        L10:
            if (this.f140855c == r101.f140855c) goto L12;
            return false;
        L12:
            if (this.f140856d == r101.f140856d) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.f140857e, r101.f140857e) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            MessageChangeType r100 = this.f140853a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = ((((((r102 * 31) + this.f140854b) * 31) + this.f140855c) * 31) + this.f140856d) * 31;
            c r104 = this.f140857e;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "MessageChangeEvent(type=" + this.f140853a + ", position=" + this.f140854b + ", rangeStart=" + this.f140855c + ", rangeEnd=" + this.f140856d + ", message=" + this.f140857e + ")";
        }

        public final MessageChangeType getType() {
            return this.f140853a;
        }

        public a(MessageChangeType r100, int r101, int r102, int r103, c r104, int r105) {
            if ((r105 & 2) == 0) goto L6;
            r101 = 0;
        L6:
            if ((r105 & 4) == 0) goto L9;
            r102 = 0;
        L9:
            if ((r105 & 8) == 0) goto L12;
            r103 = 0;
        L12:
            if ((r105 & 16) == 0) goto L14;
            r104 = null;
        L14:
            Intrinsics.checkNotNullParameter(r100, "type");
            this.f140853a = r100;
            this.f140854b = r101;
            this.f140855c = r102;
            this.f140856d = r103;
            this.f140857e = r104;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f140858a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f140859b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f140860c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f140861d;

        public b() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L14;
            b r101 = (b) r100;
            if (this.f140858a == r101.f140858a) goto L8;
            return false;
        L8:
            if (this.f140859b == r101.f140859b) goto L10;
            return false;
        L10:
            if (this.f140860c == r101.f140860c) goto L12;
            return false;
        L12:
            if (this.f140861d == r101.f140861d) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v5 */
        public final int hashCode() {
            int r100 = ((((this.f140858a * 31) + this.f140859b) * 31) + this.f140860c) * 31;
            boolean r101 = this.f140861d;
            ?? r102 = r101;
            if (r101 == false) goto L6;
            r102 = 1;
        L6:
            return r100 + r102;
        }

        public final String toString() {
            return "MessageListStatus(firstVisibleItemPosition=" + this.f140858a + ", positionOffset=" + this.f140859b + ", lastViewedPos=" + this.f140860c + ", hasFullScreen=" + this.f140861d + ")";
        }

        public b(int r100) {
            this.f140858a = 0;
            this.f140859b = 0;
            this.f140860c = 0;
            this.f140861d = false;
        }
    }

    PropertyOwner a();

    PublishSubject b();

    int c();

    com.bytedance.android.livesdk.interactivity.service.messagelist.b getConfig();

    List<c> getMessageList();
}
