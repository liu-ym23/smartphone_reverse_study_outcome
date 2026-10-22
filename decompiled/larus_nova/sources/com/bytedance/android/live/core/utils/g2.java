package com.bytedance.android.live.core.utils;

import com.bytedance.android.livesdk.followtool.utils.XTFollowSyncPrefs;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.facebook.keyframes.model.KFAnimation;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes45.dex */
public abstract class g2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPrefHelper f66173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<String> f66174b;

    public class a<T> extends b<T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ g2 f66175d;

        @Override // com.bytedance.android.live.core.utils.g2.b
        public final Object b(KProperty r100) {
            Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            long r101 = this.f66175d.f66173a.i(a(), 0);
            if ((BodyPartID.bodyIdMax & r101) != h2.b()) goto L18;
            T r102 = this.f66177b;
            if ((r102 instanceof Integer) == false) goto L9;
            return Integer.valueOf((int) (r101 >> 32));
        L9:
            if ((r102 instanceof Boolean) == false) goto L17;
            if ((r101 >> 32) != 1) goto L13;
            boolean r103 = true;
        L15:
            return Boolean.valueOf(r103);
        L13:
            r103 = false;
            goto L15
        L17:
            throw new IllegalStateException(("not support type " + this.f66177b.getClass()).toString());
        L18:
            return this.f66177b;
        }

        @Override // com.bytedance.android.live.core.utils.g2.b
        public final void c(KProperty r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            Intrinsics.checkNotNullParameter(r101, "value");
            SharedPrefHelper r102 = this.f66175d.f66173a;
            if ((r101 instanceof Integer) == false) goto L6;
            r102.m(a(), Long.valueOf((((long) ((Number) r101).intValue()) << 32) | h2.b()));
            return;
        L6:
            if ((r101 instanceof Boolean) == false) goto L14;
            String r103 = a();
            if (((Boolean) r101).booleanValue() == false) goto L10;
            long r104 = 1;
        L11:
            r102.m(r103, Long.valueOf((r104 << 32) | h2.b()));
            return;
        L10:
            r104 = 0;
            goto L11
        L14:
            throw new IllegalStateException(("not support type " + this.f66177b.getClass()).toString());
        }

        public a(g2 r100, String r101, T r102) {
            Intrinsics.checkNotNullParameter(r101, "key");
            Intrinsics.checkNotNullParameter(r102, "default");
            this.f66175d = r100;
            super(r100, r101, r102);
        }
    }

    public class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f66176a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f66177b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ g2 f66178c;

        public String a() {
            return this.f66176a;
        }

        public Object b(KProperty r100) {
            Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            SharedPrefHelper r101 = this.f66178c.f66173a;
            T r102 = this.f66177b;
            if ((r102 instanceof String) == false) goto L10;
            String r103 = r101.j(a(), (String) this.f66177b);
            if (r103 == null) goto L8;
            return r103;
        L8:
            throw new NullPointerException("null cannot be cast to non-null type T");
        L10:
            if ((r102 instanceof Integer) == false) goto L13;
            return Integer.valueOf(r101.h(a(), ((Number) this.f66177b).intValue()));
        L13:
            if ((r102 instanceof Long) == false) goto L16;
            return Long.valueOf(r101.i(a(), ((Number) this.f66177b).longValue()));
        L16:
            if ((r102 instanceof Boolean) == false) goto L19;
            return Boolean.valueOf(r101.f(a(), ((Boolean) this.f66177b).booleanValue()));
        L19:
            if ((r102 instanceof Float) == false) goto L22;
            return Float.valueOf(r101.g(a(), ((Number) this.f66177b).floatValue()));
        L22:
            if ((r102 instanceof Set) == false) goto L34;
            String r104 = a();
            T r105 = this.f66177b;
            if (r105 == null) goto L32;
            Set<String> r106 = r101.k(r104, (Set) r105);
            if (r106 == null) goto L30;
            return r106;
        L30:
            throw new NullPointerException("null cannot be cast to non-null type T");
        L32:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
        L34:
            throw new IllegalStateException(("not support type " + this.f66177b.getClass()).toString());
        }

        public void c(KProperty r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            Intrinsics.checkNotNullParameter(r101, "value");
            this.f66178c.f66173a.m(a(), r101);
        }

        public b(g2 r100, String r101, T r102) {
            Intrinsics.checkNotNullParameter(r101, "key");
            Intrinsics.checkNotNullParameter(r102, "default");
            this.f66178c = r100;
            this.f66176a = r101;
            this.f66177b = r102;
        }
    }

    public final class c<T> extends a<T> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f66179e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ g2 f66180f;

        @Override // com.bytedance.android.live.core.utils.g2.b
        public final String a() {
            StringBuilder r100 = new StringBuilder();
            r100.append(this.f66179e);
            Function0<String> r101 = this.f66180f.f66174b;
            if (r101 == null) goto L7;
            r100.append(r101.invoke());
            return r100.toString();
        L7:
            throw new IllegalArgumentException("[PrefUserKey] should use after [TypeDelegationPrefs.userId] imps".toString());
        }

        public c(XTFollowSyncPrefs r100, String r101, Object r102) {
            Intrinsics.checkNotNullParameter(r101, "key");
            Intrinsics.checkNotNullParameter(r102, "default");
            this.f66180f = r100;
            super(r100, r101, r102);
            this.f66179e = r101;
        }
    }

    public final class d<T> extends b<T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f66181d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ g2 f66182e;

        @Override // com.bytedance.android.live.core.utils.g2.b
        public final String a() {
            StringBuilder r100 = new StringBuilder();
            r100.append(this.f66181d);
            Function0<String> r101 = this.f66182e.f66174b;
            if (r101 == null) goto L7;
            r100.append(r101.invoke());
            return r100.toString();
        L7:
            throw new IllegalArgumentException("[PrefUserKey] should use after [TypeDelegationPrefs.userId] imps".toString());
        }

        public d(XTFollowSyncPrefs r100, String r101, Object r102) {
            Intrinsics.checkNotNullParameter(r101, "key");
            Intrinsics.checkNotNullParameter(r102, "default");
            this.f66182e = r100;
            super(r100, r101, r102);
            this.f66181d = r101;
        }
    }

    public final class e<T> extends g<T> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f66183e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ g2 f66184f;

        @Override // com.bytedance.android.live.core.utils.g2.b
        public final String a() {
            StringBuilder r100 = new StringBuilder();
            r100.append(this.f66183e);
            Function0<String> r101 = this.f66184f.f66174b;
            if (r101 == null) goto L7;
            r100.append(r101.invoke());
            return r100.toString();
        L7:
            throw new IllegalArgumentException("[PrefUserKey] should use after [TypeDelegationPrefs.userId] imps".toString());
        }

        public e(XTFollowSyncPrefs r100, Object r101) {
            Intrinsics.checkNotNullParameter("follow_relations_dialog_cnt_week_days", "key");
            Intrinsics.checkNotNullParameter(r101, "default");
            this.f66184f = r100;
            super(r100, r101);
            this.f66183e = "follow_relations_dialog_cnt_week_days";
        }
    }

    public final class f<T> extends h<T> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f66185e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ g2 f66186f;

        @Override // com.bytedance.android.live.core.utils.g2.b
        public final String a() {
            StringBuilder r100 = new StringBuilder();
            r100.append(this.f66185e);
            Function0<String> r101 = this.f66186f.f66174b;
            if (r101 == null) goto L7;
            r100.append(r101.invoke());
            return r100.toString();
        L7:
            throw new IllegalArgumentException("[PrefUserKey] should use after [TypeDelegationPrefs.userId] imps".toString());
        }

        public f(XTFollowSyncPrefs r100, Object r101) {
            Intrinsics.checkNotNullParameter("follow_dialog_cnt_week", "key");
            Intrinsics.checkNotNullParameter(r101, "default");
            this.f66186f = r100;
            super(r100, r101);
            this.f66185e = "follow_dialog_cnt_week";
        }
    }

    public class g<T> extends b<T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ g2 f66187d;

        @Override // com.bytedance.android.live.core.utils.g2.b
        public final Object b(KProperty r100) {
            Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            long r101 = this.f66187d.f66173a.i(a(), 0);
            if ((h2.b() - (BodyPartID.bodyIdMax & r101)) > 7) goto L18;
            T r102 = this.f66177b;
            if ((r102 instanceof Integer) == false) goto L9;
            return Integer.valueOf((int) (r101 >> 32));
        L9:
            if ((r102 instanceof Boolean) == false) goto L17;
            if ((r101 >> 32) != 1) goto L13;
            boolean r103 = true;
        L15:
            return Boolean.valueOf(r103);
        L13:
            r103 = false;
            goto L15
        L17:
            throw new IllegalStateException(("not support type " + this.f66177b.getClass()).toString());
        L18:
            return this.f66177b;
        }

        public g(XTFollowSyncPrefs r100, Object r101) {
            Intrinsics.checkNotNullParameter("follow_relations_dialog_cnt_week_days", "key");
            Intrinsics.checkNotNullParameter(r101, "default");
            this.f66187d = r100;
            super(r100, "follow_relations_dialog_cnt_week_days", r101);
        }

        @Override // com.bytedance.android.live.core.utils.g2.b
        public final void c(KProperty r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            Intrinsics.checkNotNullParameter(r101, "value");
            SharedPrefHelper r102 = this.f66187d.f66173a;
            if ((r101 instanceof Integer) == false) goto L6;
            r102.m(a(), Long.valueOf((((long) ((Number) r101).intValue()) << 32) | h2.b()));
            return;
        L6:
            if ((r101 instanceof Boolean) == false) goto L14;
            String r103 = a();
            if (((Boolean) r101).booleanValue() == false) goto L10;
            long r104 = 1;
        L11:
            r102.m(r103, Long.valueOf((r104 << 32) | h2.b()));
            return;
        L10:
            r104 = 0;
            goto L11
        L14:
            throw new IllegalStateException(("not support type " + this.f66177b.getClass()).toString());
        }
    }

    public class h<T> extends b<T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ g2 f66188d;

        @Override // com.bytedance.android.live.core.utils.g2.b
        public final Object b(KProperty r100) {
            throw null;
        }

        public h(XTFollowSyncPrefs r100, Object r101) {
            Intrinsics.checkNotNullParameter("follow_dialog_cnt_week", "key");
            Intrinsics.checkNotNullParameter(r101, "default");
            this.f66188d = r100;
            super(r100, "follow_dialog_cnt_week", r101);
        }

        @Override // com.bytedance.android.live.core.utils.g2.b
        public final void c(KProperty r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            Intrinsics.checkNotNullParameter(r101, "value");
            SharedPrefHelper r102 = this.f66188d.f66173a;
            if ((r101 instanceof Integer) == false) goto L6;
            r102.m(a(), Long.valueOf((((long) ((Number) r101).intValue()) << 32) | h2.a()));
            return;
        L6:
            if ((r101 instanceof Boolean) == false) goto L14;
            String r103 = a();
            if (((Boolean) r101).booleanValue() == false) goto L10;
            long r104 = 1;
        L11:
            r102.m(r103, Long.valueOf((r104 << 32) | h2.a()));
            return;
        L10:
            r104 = 0;
            goto L11
        L14:
            throw new IllegalStateException(("not support type " + this.f66177b.getClass()).toString());
        }
    }

    public g2(String r100, Function0<String> r101) {
        this.f66174b = r101;
        if (r100 != null) goto L5;
        SharedPrefHelper r102 = SharedPrefHelper.b(LiveResUtil.getContext());
    L6:
        this.f66173a = r102;
        return;
    L5:
        r102 = SharedPrefHelper.c(LiveResUtil.getContext(), r100);
        goto L6
    }
}
