package com.obric.autogui.platforms.tools.location;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.system.CoarseLocationInfo;
import com.obric.autogui.common.api.platform.system.IAutoActionLocationApi;
import com.obric.autogui.common.api.platform.system.POILocationInfo;
import com.obric.cae.libs.location.CoordinateTransformUtils;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.h.b.z;
import d.x;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlinx.coroutines.am;
import kotlinx.coroutines.au;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.dg;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: StandardLocationImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public class b implements IAutoActionLocationApi {
    private static final String TAG = "StandardLocationImpl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0818b f30421a = null;

    /* JADX INFO: compiled from: StandardLocationImpl.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f30422a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f30423b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f30422a, r6.f30422a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f30423b, r6.f30423b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f30422a.hashCode() * 31) + this.f30423b.hashCode();
        }

        public String toString() {
            return "AddressParts(name=" + this.f30422a + ", detail=" + this.f30423b + ')';
        }

        public a(String r2, String r3) {
            o.e(r2, "name");
            o.e(r3, "detail");
            this.f30422a = r2;
            this.f30423b = r3;
        }

        public final String a() {
            return this.f30422a;
        }

        public final String b() {
            return this.f30423b;
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.location.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: StandardLocationImpl.kt */
    public static final class C0818b {
        public /* synthetic */ C0818b(h r1) {
            this();
        }

        private C0818b() {
        }
    }

    /* JADX INFO: compiled from: StandardLocationImpl.kt */
    @d.c.b.a.f(b = "StandardLocationImpl.kt", c = {59, ITaskManager.Stub.TRANSACTION_tryActiveAgent}, d = "acquireCoarseLocation$suspendImpl", e = "com.obric.autogui.platforms.tools.location.StandardLocationImpl")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f30424a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f30425b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f30426c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f30427d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f30428e;
        /* synthetic */ Object f;
        final /* synthetic */ b g;
        int h;

        c(b r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return b.a(this.g, null, false, false, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StandardLocationImpl.kt */
    @d.c.b.a.f(b = "StandardLocationImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.platforms.tools.location.StandardLocationImpl$getAddressRepresentation$2")
    static final class d extends l implements m<am, d.c.d<? super a>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30429a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f30430b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Location f30431c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f30432d;

        d(b r3, Location r4, Context r5, d.c.d<? super d> r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30430b = r3;
            this.f30431c = r4;
            this.f30432d = ZeusTransformUtils.wrapperContext(r7, "com.obric.aiagent.plugin");
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super a> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f30430b, this.f30431c, this.f30432d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super a> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            d.c.a.b.a();
            if (this.f30429a != 0) goto L39;
            d.o.a(r9);
        L35:
            e = move-exception;
            Loog.INSTANCE.e(b.TAG, "Geocoder failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            return new a("", b.a(this.f30430b, this.f30431c));
        L6:
            if (Geocoder.isPresent() == false) goto L8;
            List<Address> r10 = new Geocoder(this.f30432d, Locale.getDefault()).getFromLocation(this.f30431c.getLatitude(), this.f30431c.getLongitude(), 1);     // Catch: Exception -> L35
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L35
            boolean r3 = true;
            if (r2 != null) goto L12;
        L15:
            boolean r4 = true;
        L16:
            if (r4 == true) goto L42;
            Address r11 = (Address) ZeusTransformUtils.preCheckCast(r10.get(0), Address.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L35
            StringBuilder r5 = new StringBuilder();     // Catch: Exception -> L35
            if (r11.getMaxAddressLineIndex() < 0) goto L21;
            r5.append(r11.getAddressLine(0));     // Catch: Exception -> L35
        L26:
            String r6 = r5.toString();     // Catch: Exception -> L35
            o.c(r6, "toString(...)");     // Catch: Exception -> L35
            CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).toString(), CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L35
            b r8 = this.f30430b;     // Catch: Exception -> L35
            Location r12 = this.f30431c;     // Catch: Exception -> L35
            if (r7.length() == 0) goto L30;
            r3 = false;
        L30:
            if (r3 == false) goto L32;
            r7 = b.a(r8, r12);     // Catch: Exception -> L35
        L32:
            String r13 = (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L35
            b r14 = this.f30430b;     // Catch: Exception -> L35
            o.a(r11);     // Catch: Exception -> L35
            return new a(b.a(r14, r11, r13), r13);
        L21:
            if (r11.getLocality() == null) goto L24;
            r5.append(r11.getLocality()).append(" ");     // Catch: Exception -> L35
        L24:
            if (r11.getSubLocality() == null) goto L26;
            r5.append(r11.getSubLocality());     // Catch: Exception -> L35
            goto L26
        L42:
            return new a("", b.a(this.f30430b, this.f30431c));
        L12:
            if (r2.isEmpty() == true) goto L15;
            r4 = false;
            goto L16
        L8:
            return new a("", b.a(this.f30430b, this.f30431c));
        L39:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: StandardLocationImpl.kt */
    @d.c.b.a.f(b = "StandardLocationImpl.kt", c = {145, 148}, d = "getFreshLocation", e = "com.obric.autogui.platforms.tools.location.StandardLocationImpl")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f30433a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f30434b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f30435c;

        e(b r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30434b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f30433a = r3;
            this.f30435c |= Integer.MIN_VALUE;
            return b.a(this.f30434b, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StandardLocationImpl.kt */
    @d.c.b.a.f(b = "StandardLocationImpl.kt", c = {149}, d = "invokeSuspend", e = "com.obric.autogui.platforms.tools.location.StandardLocationImpl$getFreshLocation$2")
    static final class f extends l implements m<am, d.c.d<? super Location>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30436a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ au<Location> f30437b;

        f(au<? extends Location> r3, d.c.d<? super f> r4) {
            au<Location> r5 = (au) ZeusTransformUtils.wrapperContextForParams(r3, au.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30437b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Location> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f30437b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Location> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f30436a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            au<Location> r6 = this.f30437b;
            d.c.d<? super Location> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30436a = 1;
            r5 = r6.a(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    static {
        f30421a = new C0818b(null);
    }

    public static /* synthetic */ String lambda$PSl0uw2khlf1l5XUjHbGnAP85VU(z.f r0) {
        return a(r0);
    }

    public static /* synthetic */ String lambda$o4b3dQe904T7rQcdvgDtO3li5W4(a r0, d.m r1) {
        return a(r0, r1);
    }

    @Override // com.obric.autogui.common.api.platform.system.IAutoActionLocationApi
    public Object acquireCoarseLocation(Context r3, boolean r4, boolean r5, d.c.d<? super com.obric.autogui.common.d<CoarseLocationInfo>> r6) {
        return a(this, (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.common.api.platform.system.IAutoActionLocationApi
    public Object acquirePOILocation(Context r3, boolean r4, d.c.d<? super com.obric.autogui.common.d<POILocationInfo>> r5) {
        return a(this, (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public b() {
    }

    public static final /* synthetic */ Object a(b r2, LocationManager r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ String a(b r0, Address r1, String r2) {
        return r0.a(r1, r2);
    }

    public static final /* synthetic */ String a(b r0, Location r1) {
        return r0.b(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v9, types: [T, android.location.Location] */
    static /* synthetic */ Object a(b r23, Context r24, boolean r25, boolean r26, d.c.d<? super com.obric.autogui.common.d<CoarseLocationInfo>> r27) {
        b r0 = r23;
        boolean r2 = r26;
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r24, Context.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r27, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, c.class) == false) goto L7;
        c r7 = (c) ZeusTransformUtils.preCheckCast(r6, c.class, "com.obric.aiagent.plugin");
        if ((r7.h & Integer.MIN_VALUE) == 0) goto L7;
        r7.h -= Integer.MIN_VALUE;
    L8:
        Object r8 = r7.f;
        Object r9 = d.c.a.b.a();
        int r10 = r7.h;
        Double r12 = null;
        if (r10 == 0) goto L24;
        if (r10 == 1) goto L19;
        if (r10 != 2) goto L18;
        boolean r1 = r7.f30428e;
        z.f r3 = (z.f) ZeusTransformUtils.preCheckCast(r7.f30425b, z.f.class, "com.obric.aiagent.plugin");
        b r5 = (b) ZeusTransformUtils.preCheckCast(r7.f30424a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r8);     // Catch: Exception -> L15
    L49:
        final a r11 = (a) ZeusTransformUtils.preCheckCast(r8, a.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L15
        final d.m<Double, Double> r13 = r5.a((Location) ZeusTransformUtils.preCheckCast(r3.f38504a, Location.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L15
        Loog.INSTANCE.dp(TAG, new $$Lambda$b$o4b3dQe904T7rQcdvgDtO3li5W4(r11, r13));     // Catch: Exception -> L15
        String r16 = r11.b();     // Catch: Exception -> L15
        String r17 = r11.a();     // Catch: Exception -> L15
        long r18 = System.currentTimeMillis();     // Catch: Exception -> L15
        if (r1 == false) goto L52;
        Double r20 = (Double) ZeusTransformUtils.preCheckCast(r13.a(), Double.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L15
    L53:
        if (r1 == false) goto L55;
        r12 = (Double) ZeusTransformUtils.preCheckCast(r13.b(), Double.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L15
    L55:
        return new com.obric.autogui.common.d(true, "", 0, new CoarseLocationInfo(true, r16, r17, r18, r20, r12));
    L52:
        r20 = null;
        goto L53
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        boolean r14 = r7.f30428e;
        z.f r15 = (z.f) ZeusTransformUtils.preCheckCast(r7.f30427d, z.f.class, "com.obric.aiagent.plugin");
        z.f r19 = (z.f) ZeusTransformUtils.preCheckCast(r7.f30426c, z.f.class, "com.obric.aiagent.plugin");
        r4 = (Context) ZeusTransformUtils.preCheckCast(r7.f30425b, Context.class, "com.obric.aiagent.plugin");
        b r21 = (b) ZeusTransformUtils.preCheckCast(r7.f30424a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r8);     // Catch: Exception -> L22
        r2 = r14;
        r0 = r21;
        T r22 = r8;
        final z.f r28 = r19;
    L40:
        r15.f38504a = r22;     // Catch: Exception -> L22
        Loog.INSTANCE.dp(TAG, new $$Lambda$b$PSl0uw2khlf1l5XUjHbGnAP85VU(r28));     // Catch: Exception -> L22
    L41:
        r3 = r28;
        if (r3.f38504a != 0) goto L45;
        Loog.INSTANCE.w(TAG, "Could not acquire location");
        return com.obric.autogui.common.d.f29012a.a("Could not acquire location");
    L45:
        Location r29 = (Location) ZeusTransformUtils.preCheckCast(r3.f38504a, Location.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L15
        r7.f30424a = r0;     // Catch: Exception -> L15
        r7.f30425b = r3;     // Catch: Exception -> L15
        r7.f30426c = null;     // Catch: Exception -> L15
        r7.f30427d = null;     // Catch: Exception -> L15
        r7.f30428e = r2;     // Catch: Exception -> L15
        r7.h = 2;     // Catch: Exception -> L15
        r8 = r0.a(r4, r29, r7);     // Catch: Exception -> L15
        if (r8 != r9) goto L48;
        return r9;
    L48:
        boolean r210 = r2;
        r5 = r0;
        r1 = r210;
        goto L49
    L24:
        d.o.a(r8);
        Loog.INSTANCE.i(TAG, "acquireCoarseLocation: forceRefresh=" + r25 + ", withLngLat=" + r2);
        Object r30 = r4.getSystemService("location");
        if (ZeusTransformUtils.instanceOf(r30, LocationManager.class) == false) goto L27;
        LocationManager r31 = (LocationManager) ZeusTransformUtils.preCheckCast(r30, LocationManager.class, "com.obric.aiagent.plugin");
    L28:
        if (r31 != null) goto L31;
        Loog.INSTANCE.e(TAG, "LocationManager not available");
        return com.obric.autogui.common.d.f29012a.a("LocationManager not available");
    L31:
        r28 = new z.f();
        if (r25 == true) goto L35;
        r28.f38504a = r0.a(r31);     // Catch: Exception -> L22
        Loog.INSTANCE.d(TAG, "getLastKnownLocation: " + r28.f38504a);     // Catch: Exception -> L22
    L35:
        if (r28.f38504a != 0) goto L41;
        Loog.INSTANCE.d(TAG, "Attempting to get fresh location...");     // Catch: Exception -> L22
        r7.f30424a = r0;     // Catch: Exception -> L22
        r7.f30425b = r4;     // Catch: Exception -> L22
        r7.f30426c = r28;     // Catch: Exception -> L22
        r7.f30427d = r28;     // Catch: Exception -> L22
        r7.f30428e = r2;     // Catch: Exception -> L22
        r7.h = 1;     // Catch: Exception -> L22
        Object r32 = r0.a(r31, r7);     // Catch: Exception -> L22
        if (r32 != r9) goto L39;
        return r9;
    L39:
        r22 = r32;
        r15 = r28;
        goto L40
    L27:
        r31 = null;
    L15:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "Error processing location info", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return com.obric.autogui.common.d.f29012a.a("Error processing location: " + e.getMessage());
    L22:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "Error acquiring location", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return com.obric.autogui.common.d.f29012a.a("Error acquiring location: " + e.getMessage());
    L7:
        r7 = new c(r0, r6);
        goto L8
    }

    private static final String a(z.f r2) {
        return "getFreshLocation: " + r2.f38504a;
    }

    private static final String a(a r2, d.m r3) {
        return "Location representation: " + r2.b() + ", name: " + r2.a() + ", transformedLocation: " + r3;
    }

    public final d.m<Double, Double> a(Location r4) {
        o.e(r4, "location");
        Location r3 = CoordinateTransformUtils.convertLocation(CoordinateTransformUtils.CoordinateSystem.WGS84, CoordinateTransformUtils.CoordinateSystem.GCJ02, r4);     // Catch: Throwable -> L5
    L7:
        if (r3 != null) goto L11;
        return new d.m(Double.valueOf(r4.getLongitude()), Double.valueOf(r4.getLatitude()));
    L11:
        return new d.m(Double.valueOf(r3.getLongitude()), Double.valueOf(r3.getLatitude()));
    L5:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "Error transforming location: " + th.getMessage());
        r3 = null;
        goto L7
    }

    static /* synthetic */ Object a(b r0, Context r1, boolean r2, d.c.d<? super com.obric.autogui.common.d<POILocationInfo>> r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.w(TAG, "acquirePOILocation: Not supported in Standard implementation");
        return com.obric.autogui.common.d.f29012a.a("Standard implementation does not support POI location");
    }

    private final Location a(LocationManager r8) {
        List<String> r7 = r8.getProviders(true);
        o.c(r7, "getProviders(...)");
        Iterator<String> r9 = r7.iterator();
        Location r0 = null;
    L4:
        if (r9.hasNext() == false) goto L16;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.aiagent.plugin");
        Location r2 = r8.getLastKnownLocation(r1);     // Catch: Exception -> L14
        if (r2 == null) goto L4;
        if (r0 == null) goto L13;
        if (r2.getTime() <= r0.getTime()) goto L4;
    L13:
        r0 = r2;
    L14:
        e = move-exception;
        Loog.INSTANCE.w(TAG, "Error getting last known location for provider " + r1 + ": " + e.getMessage());
        goto L4
    L16:
        return r0;
    }

    private final Object a(LocationManager r7, d.c.d<? super Location> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, e.class) == false) goto L7;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r9, e.class, "com.obric.aiagent.plugin");
        if ((r0.f30435c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f30435c -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.f30433a;
        Object r10 = d.c.a.b.a();
        int r2 = r0.f30435c;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        d.o.a(r6);
    L22:
        return r6;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        d.o.a(r6);
    L19:
        m r11 = (m) ZeusTransformUtils.preCheckCast(new f((au) ZeusTransformUtils.preCheckCast(r6, au.class, "com.obric.aiagent.plugin"), null), m.class, "com.obric.aiagent.plugin");
        r0.f30435c = 2;
        r6 = dg.b(WsConstants.EXIT_DELAY_TIME, r11, r0);
        if (r6 != r10) goto L22;
        return r10;
    L16:
        d.o.a(r6);
        com.obric.autogui.platforms.tools.location.a r12 = com.obric.autogui.platforms.tools.location.a.f30403a;
        r0.f30435c = 1;
        r6 = r12.a(r7, r0);
        if (r6 != r10) goto L19;
        return r10;
    L7:
        r0 = new e(this, r9);
        goto L8
    }

    private final Object a(Context r5, Location r6, d.c.d<? super a> r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        return i.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new d(this, r6, r8, null), m.class, "com.obric.aiagent.plugin"), r9);
    }

    private final String a(Address r10, String r11) {
        String r9 = r10.getAdminArea();
        String r0 = null;
        if (r9 == null) goto L5;
        String r12 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L7:
        if (r12 != null) goto L9;
        r12 = "";
    L9:
        String r3 = r10.getLocality();
        if (r3 == null) goto L12;
        String r4 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L13:
        if (r4 != null) goto L15;
        r4 = "";
    L15:
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(p.b(new String[]{r10.getThoroughfare(), r10.getSubLocality(), r10.getFeatureName()}), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L17:
        if (r13.hasNext() == false) goto L39;
        Object r5 = r13.next();
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L21;
        String r7 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L22:
        if (r7 != null) goto L25;
        r7 = "";
    L25:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L27;
        boolean r8 = true;
    L28:
        if (r8 == true) goto L30;
    L36:
        boolean r14 = false;
    L37:
        if (r14 == false) goto L17;
    L40:
        String r15 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L43;
        r0 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L43:
        if (r0 != null) goto L46;
        return "";
    L46:
        return r0;
    L30:
        if (o.a(r7, r11) == true) goto L36;
        if (o.a(r7, r12) == true) goto L36;
        if (o.a(r7, r4) == true) goto L36;
        r14 = true;
        goto L37
    L27:
        r8 = false;
        goto L28
    L21:
        r7 = null;
        goto L22
    L39:
        r5 = null;
        goto L40
    L12:
        r4 = null;
        goto L13
    L5:
        r12 = null;
        goto L7
    }

    private final String b(Location r4) {
        String r3 = String.format("%.4f, %.4f", Arrays.copyOf(new Object[]{Double.valueOf(r4.getLatitude()), Double.valueOf(r4.getLongitude())}, 2));
        o.c(r3, "format(...)");
        return r3;
    }
}
