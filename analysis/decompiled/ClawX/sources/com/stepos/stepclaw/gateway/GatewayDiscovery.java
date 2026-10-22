package com.stepos.stepclaw.gateway;

import a6.f0;
import a6.h1;
import a6.i0;
import a6.r0;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.DnsResolver;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.CancellationSignal;
import b5.a0;
import b8.h;
import c5.k;
import c5.m;
import c5.s;
import com.stepos.stepclaw.SecurePrefs;
import d6.u;
import d6.v;
import d6.w;
import d6.y;
import d6.z;
import d8.a4;
import d8.j1;
import d8.m0;
import d8.q3;
import d8.s3;
import d8.v2;
import d8.w2;
import d8.x1;
import d8.x2;
import h5.i;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import p5.p;
import w5.g;
import w5.l;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004*\u0002\u0081\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\nJ\u000f\u0010\u0015\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001f\u0010 J!\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\fH\u0002¢\u0006\u0004\b\"\u0010#J\u001f\u0010%\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\fH\u0002¢\u0006\u0004\b%\u0010&J\u0018\u0010'\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0082@¢\u0006\u0004\b'\u0010(J\u001f\u0010*\u001a\u00020\f2\u0006\u0010)\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b*\u0010\u0019J\u0017\u0010+\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\fH\u0002¢\u0006\u0004\b+\u0010\u001cJ\"\u0010/\u001a\u0004\u0018\u00010.2\u0006\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020!H\u0082@¢\u0006\u0004\b/\u00100J\u001a\u00102\u001a\u0004\u0018\u00010.2\u0006\u00101\u001a\u00020.H\u0082@¢\u0006\u0004\b2\u00103J'\u00108\u001a\b\u0012\u0004\u0012\u000207062\b\u00104\u001a\u0004\u0018\u00010.2\u0006\u00105\u001a\u00020!H\u0002¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\fH\u0002¢\u0006\u0004\b:\u0010\u001cJ1\u0010<\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u000207060;2\u0006\u00104\u001a\u00020.2\u0006\u00105\u001a\u00020!H\u0002¢\u0006\u0004\b<\u0010=J)\u0010?\u001a\u0004\u0018\u0001072\u0006\u00104\u001a\u00020.2\u0006\u0010>\u001a\u00020\f2\u0006\u0010-\u001a\u00020!H\u0002¢\u0006\u0004\b?\u0010@J#\u0010B\u001a\u0004\u0018\u00010\f2\b\u00104\u001a\u0004\u0018\u00010.2\u0006\u0010A\u001a\u00020\fH\u0002¢\u0006\u0004\bB\u0010CJ\u0011\u0010E\u001a\u0004\u0018\u00010DH\u0002¢\u0006\u0004\bE\u0010FJ\u0011\u0010H\u001a\u0004\u0018\u00010GH\u0002¢\u0006\u0004\bH\u0010IJ\"\u0010M\u001a\u00020K2\b\u0010J\u001a\u0004\u0018\u00010D2\u0006\u0010L\u001a\u00020KH\u0082@¢\u0006\u0004\bM\u0010NJ'\u0010P\u001a\u0004\u0018\u00010\f2\f\u00108\u001a\b\u0012\u0004\u0012\u00020O062\u0006\u0010\u001e\u001a\u00020\fH\u0002¢\u0006\u0004\bP\u0010QJ'\u0010R\u001a\u0004\u0018\u00010!2\f\u00108\u001a\b\u0012\u0004\u0012\u00020O062\u0006\u0010\u001e\u001a\u00020\fH\u0002¢\u0006\u0004\bR\u0010SJ%\u0010T\u001a\u00020$2\f\u00108\u001a\b\u0012\u0004\u0012\u00020O062\u0006\u0010\u001e\u001a\u00020\fH\u0002¢\u0006\u0004\bT\u0010UJ\u0017\u0010V\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\fH\u0002¢\u0006\u0004\bV\u0010\u001cJ\u001a\u0010W\u001a\u0004\u0018\u00010\f2\u0006\u0010A\u001a\u00020\fH\u0082@¢\u0006\u0004\bW\u0010(R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010XR\u0014\u0010Z\u001a\u00020Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u001c\u0010^\u001a\n ]*\u0004\u0018\u00010\\0\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010a\u001a\u00020`8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0014\u0010c\u001a\u00020\f8\u0002X\u0082D¢\u0006\u0006\n\u0004\bc\u0010dR\u001c\u0010e\u001a\n ]*\u0004\u0018\u00010\f0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010dR\u0014\u0010f\u001a\u00020\f8\u0002X\u0082D¢\u0006\u0006\n\u0004\bf\u0010dR \u0010i\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020h0g8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR \u0010k\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020h0g8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010jR \u0010m\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020h060l8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010nR#\u0010p\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020h060o8\u0006¢\u0006\f\n\u0004\bp\u0010q\u001a\u0004\br\u0010sR\u001a\u0010t\u001a\b\u0012\u0004\u0012\u00020\f0l8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010nR\u001d\u0010u\u001a\b\u0012\u0004\u0012\u00020\f0o8\u0006¢\u0006\f\n\u0004\bu\u0010q\u001a\u0004\bv\u0010sR\u0018\u0010x\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0014\u0010{\u001a\u00020z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b{\u0010|R\u0018\u0010}\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010~R\u0017\u0010\u007f\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0018\u0010\u0082\u0001\u001a\u00030\u0081\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001¨\u0006\u0084\u0001"}, d2 = {"Lcom/stepos/stepclaw/gateway/GatewayDiscovery;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Landroid/content/Context;", "context", "La6/f0;", "scope", "<init>", "(Landroid/content/Context;La6/f0;)V", "Lb5/a0;", "startLocalDiscovery", "()V", "stopLocalDiscovery", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "domain", "startUnicastDiscovery", "(Ljava/lang/String;)V", "Landroid/net/nsd/NsdServiceInfo;", "serviceInfo", "resolve", "(Landroid/net/nsd/NsdServiceInfo;)V", "publish", "buildStatusText", "()Ljava/lang/String;", "serviceName", "stableId", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "raw", "normalizeName", "(Ljava/lang/String;)Ljava/lang/String;", "info", "key", "txt", "(Landroid/net/nsd/NsdServiceInfo;Ljava/lang/String;)Ljava/lang/String;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "txtInt", "(Landroid/net/nsd/NsdServiceInfo;Ljava/lang/String;)Ljava/lang/Integer;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "txtBool", "(Landroid/net/nsd/NsdServiceInfo;Ljava/lang/String;)Z", "refreshUnicast", "(Ljava/lang/String;Lf5/c;)Ljava/lang/Object;", "instanceFqdn", "decodeInstanceName", "stripTrailingDot", "name", "type", "Ld8/j1;", "lookupUnicastMessage", "(Ljava/lang/String;ILf5/c;)Ljava/lang/Object;", "query", "queryViaSystemDns", "(Ld8/j1;Lf5/c;)Ljava/lang/Object;", "msg", "section", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Ld8/w2;", "records", "(Ld8/j1;I)Ljava/util/List;", "keyName", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "recordsByName", "(Ld8/j1;I)Ljava/util/Map;", "fqdn", "recordByName", "(Ld8/j1;Ljava/lang/String;I)Ld8/w2;", "hostname", "resolveHostFromMessage", "(Ld8/j1;Ljava/lang/String;)Ljava/lang/String;", "Landroid/net/Network;", "preferredDnsNetwork", "()Landroid/net/Network;", "Ld8/x2;", "createDirectResolver", "()Ld8/x2;", "network", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "wireQuery", "rawQuery", "(Landroid/net/Network;[BLf5/c;)Ljava/lang/Object;", "Ld8/a4;", "txtValue", "(Ljava/util/List;Ljava/lang/String;)Ljava/lang/String;", "txtIntValue", "(Ljava/util/List;Ljava/lang/String;)Ljava/lang/Integer;", "txtBoolValue", "(Ljava/util/List;Ljava/lang/String;)Z", "decodeDnsTxtString", "resolveHostUnicast", "La6/f0;", "Landroid/net/nsd/NsdManager;", "nsd", "Landroid/net/nsd/NsdManager;", "Landroid/net/ConnectivityManager;", "kotlin.jvm.PlatformType", "connectivity", "Landroid/net/ConnectivityManager;", "Landroid/net/DnsResolver;", "dns", "Landroid/net/DnsResolver;", "serviceType", "Ljava/lang/String;", "wideAreaDomain", "logTag", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/stepos/stepclaw/gateway/GatewayEndpoint;", "localById", "Ljava/util/concurrent/ConcurrentHashMap;", "unicastById", "Ld6/u;", "_gateways", "Ld6/u;", "Ld6/w;", "gateways", "Ld6/w;", "getGateways", "()Ld6/w;", "_statusText", "statusText", "getStatusText", "La6/h1;", "unicastJob", "La6/h1;", "Ljava/util/concurrent/Executor;", "dnsExecutor", "Ljava/util/concurrent/Executor;", "lastWideAreaRcode", "Ljava/lang/Integer;", "lastWideAreaCount", "I", "com/stepos/stepclaw/gateway/GatewayDiscovery$discoveryListener$1", "discoveryListener", "Lcom/stepos/stepclaw/gateway/GatewayDiscovery$discoveryListener$1;", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GatewayDiscovery {
    private final u _gateways;
    private final u _statusText;
    private final ConnectivityManager connectivity;
    private final GatewayDiscovery$discoveryListener$1 discoveryListener;
    private final DnsResolver dns;
    private final Executor dnsExecutor;
    private final w gateways;
    private volatile int lastWideAreaCount;
    private volatile Integer lastWideAreaRcode;
    private final ConcurrentHashMap<String, GatewayEndpoint> localById;
    private final String logTag;
    private final NsdManager nsd;
    private final f0 scope;
    private final String serviceType;
    private final w statusText;
    private final ConcurrentHashMap<String, GatewayEndpoint> unicastById;
    private h1 unicastJob;
    private final String wideAreaDomain;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.gateway.GatewayDiscovery", f = "GatewayDiscovery.kt", l = {353}, m = "lookupUnicastMessage", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.gateway.GatewayDiscovery$lookupUnicastMessage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends h5.c {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GatewayDiscovery.this.lookupUnicastMessage(null, 0, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.gateway.GatewayDiscovery", f = "GatewayDiscovery.kt", l = {369}, m = "queryViaSystemDns", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.gateway.GatewayDiscovery$queryViaSystemDns$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00211 extends h5.c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C00211(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GatewayDiscovery.this.queryViaSystemDns(null, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.gateway.GatewayDiscovery", f = "GatewayDiscovery.kt", l = {245, 254, 265, 268, 279}, m = "refreshUnicast", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.gateway.GatewayDiscovery$refreshUnicast$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00221 extends h5.c {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public C00221(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GatewayDiscovery.this.refreshUnicast(null, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.gateway.GatewayDiscovery", f = "GatewayDiscovery.kt", l = {563, 567}, m = "resolveHostUnicast", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.gateway.GatewayDiscovery$resolveHostUnicast$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00241 extends h5.c {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C00241(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GatewayDiscovery.this.resolveHostUnicast(null, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.gateway.GatewayDiscovery$startUnicastDiscovery$1", f = "GatewayDiscovery.kt", l = {132, 136}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.gateway.GatewayDiscovery$startUnicastDiscovery$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00251 extends i implements p {
        final /* synthetic */ String $domain;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00251(String str, f5.c cVar) {
            super(2, cVar);
            this.$domain = str;
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return GatewayDiscovery.this.new C00251(this.$domain, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((C00251) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x001c A[Catch: all -> 0x0029, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0029, blocks: (B:9:0x0015, B:12:0x001c), top: B:19:0x0015 }] */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0029  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0031 -> B:12:0x001c). Please report as a decompilation issue!!! */
        @Override // h5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                g5.a r0 = g5.a.f2984a
                int r1 = r6.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L19
                if (r1 == r3) goto L15
                if (r1 != r2) goto Ld
                goto L19
            Ld:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L15:
                a.a.c0(r7)     // Catch: java.lang.Throwable -> L29
                goto L29
            L19:
                a.a.c0(r7)
            L1c:
                com.stepos.stepclaw.gateway.GatewayDiscovery r7 = com.stepos.stepclaw.gateway.GatewayDiscovery.this     // Catch: java.lang.Throwable -> L29
                java.lang.String r1 = r6.$domain     // Catch: java.lang.Throwable -> L29
                r6.label = r3     // Catch: java.lang.Throwable -> L29
                java.lang.Object r7 = com.stepos.stepclaw.gateway.GatewayDiscovery.access$refreshUnicast(r7, r1, r6)     // Catch: java.lang.Throwable -> L29
                if (r7 != r0) goto L29
                goto L33
            L29:
                r6.label = r2
                r4 = 5000(0x1388, double:2.4703E-320)
                java.lang.Object r7 = a6.i0.g(r4, r6)
                if (r7 != r0) goto L1c
            L33:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.gateway.GatewayDiscovery.C00251.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Type inference failed for: r3v14, types: [com.stepos.stepclaw.gateway.GatewayDiscovery$discoveryListener$1] */
    public GatewayDiscovery(Context context, f0 scope) {
        kotlin.jvm.internal.p.e(context, "context");
        kotlin.jvm.internal.p.e(scope, "scope");
        this.scope = scope;
        Object systemService = context.getSystemService((Class<Object>) NsdManager.class);
        kotlin.jvm.internal.p.b(systemService);
        this.nsd = (NsdManager) systemService;
        this.connectivity = (ConnectivityManager) context.getSystemService(ConnectivityManager.class);
        DnsResolver dnsResolver = DnsResolver.getInstance();
        kotlin.jvm.internal.p.d(dnsResolver, "getInstance(...)");
        this.dns = dnsResolver;
        this.serviceType = "_openclaw-gw._tcp.";
        String str = System.getenv("OPENCLAW_WIDE_AREA_DOMAIN");
        this.wideAreaDomain = str;
        this.logTag = "OpenClaw/GatewayDiscovery";
        this.localById = new ConcurrentHashMap<>();
        this.unicastById = new ConcurrentHashMap<>();
        y yVarA = z.a(s.f1092a);
        this._gateways = yVarA;
        this.gateways = new v(yVarA);
        y yVarA2 = z.a("Searching…");
        this._statusText = yVarA2;
        this.statusText = new v(yVarA2);
        ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
        kotlin.jvm.internal.p.d(executorServiceNewCachedThreadPool, "newCachedThreadPool(...)");
        this.dnsExecutor = executorServiceNewCachedThreadPool;
        this.discoveryListener = new NsdManager.DiscoveryListener() { // from class: com.stepos.stepclaw.gateway.GatewayDiscovery$discoveryListener$1
            @Override // android.net.nsd.NsdManager.DiscoveryListener
            public void onDiscoveryStarted(String serviceType) {
                kotlin.jvm.internal.p.e(serviceType, "serviceType");
            }

            @Override // android.net.nsd.NsdManager.DiscoveryListener
            public void onDiscoveryStopped(String serviceType) {
                kotlin.jvm.internal.p.e(serviceType, "serviceType");
            }

            @Override // android.net.nsd.NsdManager.DiscoveryListener
            public void onServiceFound(NsdServiceInfo serviceInfo) {
                kotlin.jvm.internal.p.e(serviceInfo, "serviceInfo");
                if (kotlin.jvm.internal.p.a(serviceInfo.getServiceType(), this.this$0.serviceType)) {
                    this.this$0.resolve(serviceInfo);
                }
            }

            @Override // android.net.nsd.NsdManager.DiscoveryListener
            public void onServiceLost(NsdServiceInfo serviceInfo) {
                kotlin.jvm.internal.p.e(serviceInfo, "serviceInfo");
                BonjourEscapes bonjourEscapes = BonjourEscapes.INSTANCE;
                String serviceName = serviceInfo.getServiceName();
                kotlin.jvm.internal.p.d(serviceName, "getServiceName(...)");
                this.this$0.localById.remove(this.this$0.stableId(bonjourEscapes.decode(serviceName), "local."));
                this.this$0.publish();
            }

            @Override // android.net.nsd.NsdManager.DiscoveryListener
            public void onStartDiscoveryFailed(String serviceType, int errorCode) {
                kotlin.jvm.internal.p.e(serviceType, "serviceType");
            }

            @Override // android.net.nsd.NsdManager.DiscoveryListener
            public void onStopDiscoveryFailed(String serviceType, int errorCode) {
                kotlin.jvm.internal.p.e(serviceType, "serviceType");
            }
        };
        startLocalDiscovery();
        if (str == null || n.t1(str)) {
            return;
        }
        startUnicastDiscovery(str);
    }

    private final String buildStatusText() {
        String strC;
        int size = this.localById.size();
        Integer num = this.lastWideAreaRcode;
        int i8 = this.lastWideAreaCount;
        if (num == null) {
            strC = "Wide: ?";
        } else if (num.intValue() == 0) {
            strC = a8.b.j(i8, "Wide: ");
        } else if (num.intValue() == 3) {
            strC = "Wide: NXDOMAIN";
        } else {
            strC = m0.f.c("Wide: ", v2.f2185a.d(num.intValue()));
        }
        if (size == 0 && num == null) {
            return "Searching for gateways…";
        }
        if (size == 0) {
            return String.valueOf(strC);
        }
        return "Local: " + size + " • " + strC;
    }

    private final x2 createDirectResolver() {
        Network network;
        List<InetAddress> listS;
        s3 s3Var;
        ConnectivityManager connectivityManager = this.connectivity;
        if (connectivityManager != null) {
            d5.c cVarP = a.a.p();
            Network[] allNetworks = connectivityManager.getAllNetworks();
            kotlin.jvm.internal.p.d(allNetworks, "getAllNetworks(...)");
            int length = allNetworks.length;
            int i8 = 0;
            int i9 = 0;
            while (true) {
                if (i9 >= length) {
                    network = null;
                    break;
                }
                network = allNetworks[i9];
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
                if (networkCapabilities == null ? false : networkCapabilities.hasTransport(4)) {
                    break;
                }
                i9++;
            }
            if (network != null) {
                cVarP.add(network);
            }
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork != null) {
                cVarP.add(activeNetwork);
            }
            d5.c cVarE = a.a.e(cVarP);
            kotlin.jvm.internal.p.e(cVarE, "<this>");
            k kVarQ0 = m.q0(m.N0(m.Q0(cVarE)));
            c5.a aVar = new c5.a(3, connectivityManager);
            l lVar = l.f6221a;
            w5.b bVar = new w5.b(new w5.f(new g(kVarQ0, aVar), (byte) 0), new d(i8));
            if (bVar.hasNext()) {
                Object next = bVar.next();
                if (bVar.hasNext()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(next);
                    while (bVar.hasNext()) {
                        arrayList.add(bVar.next());
                    }
                    listS = arrayList;
                } else {
                    listS = a.a.S(next);
                }
            } else {
                listS = s.f1092a;
            }
            if (!listS.isEmpty()) {
                try {
                    ArrayList arrayList2 = new ArrayList();
                    for (InetAddress inetAddress : listS) {
                        try {
                            s3Var = new s3();
                            s3Var.f2168a = new InetSocketAddress(inetAddress, 53);
                            s3Var.f2170c = Duration.ofSeconds(3);
                        } catch (Throwable unused) {
                            s3Var = null;
                        }
                        if (s3Var != null) {
                            arrayList2.add(s3Var);
                        }
                    }
                    if (!arrayList2.isEmpty()) {
                        m0 m0Var = new m0((x2[]) arrayList2.toArray(new s3[0]));
                        m0Var.f2081c = Duration.ofSeconds(3);
                        return m0Var;
                    }
                } catch (Throwable unused2) {
                    return null;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w5.i createDirectResolver$lambda$1(ConnectivityManager connectivityManager, Network n3) {
        List<InetAddress> dnsServers;
        kotlin.jvm.internal.p.e(n3, "n");
        LinkProperties linkProperties = connectivityManager.getLinkProperties(n3);
        return (linkProperties == null || (dnsServers = linkProperties.getDnsServers()) == null) ? w5.e.f6207a : m.q0(dnsServers);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String createDirectResolver$lambda$2(InetAddress inetAddress) {
        String hostAddress = inetAddress.getHostAddress();
        if (hostAddress != null) {
            return hostAddress;
        }
        String string = inetAddress.toString();
        kotlin.jvm.internal.p.d(string, "toString(...)");
        return string;
    }

    private final String decodeDnsTxtString(String raw) {
        byte[] bytes = raw.getBytes(x5.a.f6278c);
        kotlin.jvm.internal.p.d(bytes, "getBytes(...)");
        CharsetDecoder charsetDecoderNewDecoder = x5.a.f6276a.newDecoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
        try {
            String string = charsetDecoderNewDecoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).decode(ByteBuffer.wrap(bytes)).toString();
            kotlin.jvm.internal.p.b(string);
            return string;
        } catch (Throwable unused) {
            return raw;
        }
    }

    private final String decodeInstanceName(String instanceFqdn, String domain) {
        String strN = a8.b.n(this.serviceType, domain);
        return normalizeName(stripTrailingDot(x5.u.V0(instanceFqdn, strN, false) ? n.C1(instanceFqdn, strN) : n.O1(instanceFqdn, this.serviceType)));
    }

    private final String keyName(String raw) {
        String lowerCase = n.T1(raw).toString().toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.p.d(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object lookupUnicastMessage(java.lang.String r8, int r9, f5.c r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.stepos.stepclaw.gateway.GatewayDiscovery.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.stepclaw.gateway.GatewayDiscovery$lookupUnicastMessage$1 r0 = (com.stepos.stepclaw.gateway.GatewayDiscovery.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.stepclaw.gateway.GatewayDiscovery$lookupUnicastMessage$1 r0 = new com.stepos.stepclaw.gateway.GatewayDiscovery$lookupUnicastMessage$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            g5.a r1 = g5.a.f2984a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            int r9 = r0.I$0
            java.lang.Object r8 = r0.L$1
            d8.j1 r8 = (d8.j1) r8
            java.lang.Object r0 = r0.L$0
            java.lang.String r0 = (java.lang.String) r0
            a.a.c0(r10)
            goto L77
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L39:
            a.a.c0(r10)
            r10 = 0
            d8.x1 r8 = d8.x1.f(r8, r10)     // Catch: java.lang.Throwable -> Lc8
            r4 = 0
            d8.w2 r8 = d8.w2.h(r8, r9, r3, r4)     // Catch: java.lang.Throwable -> Lc8
            d8.j1 r2 = new d8.j1     // Catch: java.lang.Throwable -> Lc8
            r2.<init>()     // Catch: java.lang.Throwable -> Lc8
            d8.u0 r4 = r2.f2031a     // Catch: java.lang.Throwable -> Lc8
            r4.e()     // Catch: java.lang.Throwable -> Lc8
            d8.u0 r4 = r2.f2031a     // Catch: java.lang.Throwable -> Lc8
            r4.getClass()     // Catch: java.lang.Throwable -> Lc8
            r5 = 7
            d8.u0.a(r5)     // Catch: java.lang.Throwable -> Lc8
            int r6 = r4.f2176b     // Catch: java.lang.Throwable -> Lc8
            d8.u0.a(r5)     // Catch: java.lang.Throwable -> Lc8
            r5 = r6 | 256(0x100, float:3.59E-43)
            r4.f2176b = r5     // Catch: java.lang.Throwable -> Lc8
            r4 = 0
            r2.a(r8, r4)     // Catch: java.lang.Throwable -> Lc8
            r0.L$0 = r10
            r0.L$1 = r2
            r0.I$0 = r9
            r0.label = r3
            java.lang.Object r10 = r7.queryViaSystemDns(r2, r0)
            if (r10 != r1) goto L76
            return r1
        L76:
            r8 = r2
        L77:
            d8.j1 r10 = (d8.j1) r10
            java.util.List r0 = r7.records(r10, r3)
            if (r0 == 0) goto L86
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L86
            goto L9b
        L86:
            java.util.Iterator r0 = r0.iterator()
        L8a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L9b
            java.lang.Object r1 = r0.next()
            d8.w2 r1 = (d8.w2) r1
            int r1 = r1.f2196b
            if (r1 != r9) goto L8a
            goto Lc8
        L9b:
            d8.x2 r0 = r7.createDirectResolver()
            if (r0 != 0) goto La2
            goto Lc8
        La2:
            d8.j1 r8 = r0.a(r8)
            java.util.List r7 = r7.records(r8, r3)
            if (r7 == 0) goto Lb3
            boolean r0 = r7.isEmpty()
            if (r0 == 0) goto Lb3
            goto Lc8
        Lb3:
            java.util.Iterator r7 = r7.iterator()
        Lb7:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto Lc8
            java.lang.Object r0 = r7.next()
            d8.w2 r0 = (d8.w2) r0
            int r0 = r0.f2196b
            if (r0 != r9) goto Lb7
            return r8
        Lc8:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.gateway.GatewayDiscovery.lookupUnicastMessage(java.lang.String, int, f5.c):java.lang.Object");
    }

    private final String normalizeName(String raw) {
        Collection collectionS;
        String input = n.T1(raw).toString();
        Pattern patternCompile = Pattern.compile("\\s+");
        kotlin.jvm.internal.p.d(patternCompile, "compile(...)");
        kotlin.jvm.internal.p.e(input, "input");
        int iEnd = 0;
        n.E1(0);
        Matcher matcher = patternCompile.matcher(input);
        if (matcher.find()) {
            ArrayList arrayList = new ArrayList(10);
            do {
                arrayList.add(input.subSequence(iEnd, matcher.start()).toString());
                iEnd = matcher.end();
            } while (matcher.find());
            arrayList.add(input.subSequence(iEnd, input.length()).toString());
            collectionS = arrayList;
        } else {
            collectionS = a.a.S(input.toString());
        }
        return m.A0(collectionS, " ", null, null, null, 62);
    }

    private final Network preferredDnsNetwork() {
        ConnectivityManager connectivityManager = this.connectivity;
        Network network = null;
        if (connectivityManager == null) {
            return null;
        }
        Network[] allNetworks = connectivityManager.getAllNetworks();
        kotlin.jvm.internal.p.d(allNetworks, "getAllNetworks(...)");
        int length = allNetworks.length;
        int i8 = 0;
        while (true) {
            if (i8 >= length) {
                break;
            }
            Network network2 = allNetworks[i8];
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network2);
            if (networkCapabilities == null ? false : networkCapabilities.hasTransport(4)) {
                network = network2;
                break;
            }
            i8++;
        }
        return network != null ? network : connectivityManager.getActiveNetwork();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void publish() {
        u uVar = this._gateways;
        Collection<GatewayEndpoint> collectionValues = this.localById.values();
        kotlin.jvm.internal.p.d(collectionValues, "<get-values>(...)");
        Collection<GatewayEndpoint> collectionValues2 = this.unicastById.values();
        kotlin.jvm.internal.p.d(collectionValues2, "<get-values>(...)");
        List listJ0 = m.J0(m.E0(collectionValues, collectionValues2), new Comparator() { // from class: com.stepos.stepclaw.gateway.GatewayDiscovery$publish$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t8, T t9) {
                String name = ((GatewayEndpoint) t8).getName();
                Locale locale = Locale.ROOT;
                String lowerCase = name.toLowerCase(locale);
                kotlin.jvm.internal.p.d(lowerCase, "toLowerCase(...)");
                String lowerCase2 = ((GatewayEndpoint) t9).getName().toLowerCase(locale);
                kotlin.jvm.internal.p.d(lowerCase2, "toLowerCase(...)");
                return a.a.l(lowerCase, lowerCase2);
            }
        });
        y yVar = (y) uVar;
        yVar.getClass();
        yVar.c(null, listJ0);
        ((y) this._statusText).b(buildStatusText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object queryViaSystemDns(d8.j1 r6, f5.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.stepos.stepclaw.gateway.GatewayDiscovery.C00211
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.stepclaw.gateway.GatewayDiscovery$queryViaSystemDns$1 r0 = (com.stepos.stepclaw.gateway.GatewayDiscovery.C00211) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.stepclaw.gateway.GatewayDiscovery$queryViaSystemDns$1 r0 = new com.stepos.stepclaw.gateway.GatewayDiscovery$queryViaSystemDns$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            g5.a r1 = g5.a.f2984a
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r5 = r0.L$1
            android.net.Network r5 = (android.net.Network) r5
            java.lang.Object r5 = r0.L$0
            d8.j1 r5 = (d8.j1) r5
            a.a.c0(r7)     // Catch: java.io.IOException -> L58
            goto L50
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            a.a.c0(r7)
            android.net.Network r7 = r5.preferredDnsNetwork()
            byte[] r6 = r6.f()     // Catch: java.io.IOException -> L58
            r0.L$0 = r4     // Catch: java.io.IOException -> L58
            r0.L$1 = r4     // Catch: java.io.IOException -> L58
            r0.label = r3     // Catch: java.io.IOException -> L58
            java.lang.Object r7 = r5.rawQuery(r7, r6, r0)     // Catch: java.io.IOException -> L58
            if (r7 != r1) goto L50
            return r1
        L50:
            byte[] r7 = (byte[]) r7     // Catch: java.io.IOException -> L58
            d8.j1 r5 = new d8.j1
            r5.<init>(r7)
            return r5
        L58:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.gateway.GatewayDiscovery.queryViaSystemDns(d8.j1, f5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object rawQuery(Network network, byte[] bArr, f5.c cVar) {
        final a6.m mVar = new a6.m(1, h.u(cVar));
        mVar.t();
        final CancellationSignal cancellationSignal = new CancellationSignal();
        mVar.v(new p5.l() { // from class: com.stepos.stepclaw.gateway.GatewayDiscovery$rawQuery$2$1
            @Override // p5.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return a0.f883a;
            }

            public final void invoke(Throwable th) {
                cancellationSignal.cancel();
            }
        });
        this.dns.rawQuery(network, bArr, 0, this.dnsExecutor, cancellationSignal, new DnsResolver.Callback<byte[]>() { // from class: com.stepos.stepclaw.gateway.GatewayDiscovery$rawQuery$2$2
            @Override // android.net.DnsResolver.Callback
            public void onError(DnsResolver.DnsException error) {
                kotlin.jvm.internal.p.e(error, "error");
                mVar.resumeWith(a.a.o(error));
            }

            @Override // android.net.DnsResolver.Callback
            public void onAnswer(byte[] answer, int rcode) {
                kotlin.jvm.internal.p.e(answer, "answer");
                mVar.resumeWith(answer);
            }
        });
        Object objS = mVar.s();
        g5.a aVar = g5.a.f2984a;
        return objS;
    }

    private final w2 recordByName(j1 msg, String fqdn, int type) {
        Object obj;
        Object next;
        String strKeyName = keyName(fqdn);
        List<w2> list = recordsByName(msg, 1).get(strKeyName);
        List<w2> list2 = s.f1092a;
        if (list == null) {
            list = list2;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((w2) next).f2196b == type) {
                break;
            }
        }
        w2 w2Var = (w2) next;
        if (w2Var != null) {
            return w2Var;
        }
        List<w2> list3 = recordsByName(msg, 3).get(strKeyName);
        if (list3 != null) {
            list2 = list3;
        }
        Iterator<T> it2 = list2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            if (((w2) next2).f2196b == type) {
                obj = next2;
                break;
            }
        }
        return (w2) obj;
    }

    private final List<w2> records(j1 msg, int section) {
        if (msg != null) {
            q3.f2122a.c(section);
            List list = msg.f2032b[section];
            w2[] w2VarArr = list == null ? j1.f2030f : (w2[]) list.toArray(new w2[0]);
            if (w2VarArr != null) {
                return c5.l.j0(w2VarArr);
            }
        }
        return s.f1092a;
    }

    private final Map<String, List<w2>> recordsByName(j1 msg, int section) {
        String string;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (w2 w2Var : records(msg, section)) {
            x1 x1Var = w2Var.f2195a;
            if (x1Var != null && (string = x1Var.toString()) != null) {
                String strKeyName = keyName(string);
                Object arrayList = linkedHashMap.get(strKeyName);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(strKeyName, arrayList);
                }
                ((List) arrayList).add(w2Var);
            }
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0146, code lost:
    
        if (r6 == r5) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0313, code lost:
    
        if (r12 == r5) goto L99;
     */
    /* JADX WARN: Path cross not found for [B:51:0x01e1, B:52:0x01e3], limit reached: 126 */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02ef  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:115:0x03a0 -> B:38:0x0186). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x01f1 -> B:38:0x0186). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x0277 -> B:38:0x0186). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:95:0x02e5 -> B:96:0x02ec). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:98:0x0313 -> B:100:0x0316). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object refreshUnicast(java.lang.String r32, f5.c r33) {
        /*
            Method dump skipped, instructions count: 1000
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.gateway.GatewayDiscovery.refreshUnicast(java.lang.String, f5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resolve(NsdServiceInfo serviceInfo) {
        this.nsd.resolveService(serviceInfo, new NsdManager.ResolveListener() { // from class: com.stepos.stepclaw.gateway.GatewayDiscovery.resolve.1
            @Override // android.net.nsd.NsdManager.ResolveListener
            public void onResolveFailed(NsdServiceInfo serviceInfo2, int errorCode) {
                kotlin.jvm.internal.p.e(serviceInfo2, "serviceInfo");
            }

            @Override // android.net.nsd.NsdManager.ResolveListener
            public void onServiceResolved(NsdServiceInfo resolved) {
                String hostAddress;
                int port;
                kotlin.jvm.internal.p.e(resolved, "resolved");
                InetAddress host = resolved.getHost();
                if (host == null || (hostAddress = host.getHostAddress()) == null || (port = resolved.getPort()) <= 0) {
                    return;
                }
                String serviceName = resolved.getServiceName();
                BonjourEscapes bonjourEscapes = BonjourEscapes.INSTANCE;
                kotlin.jvm.internal.p.b(serviceName);
                String strDecode = bonjourEscapes.decode(serviceName);
                String strTxt = GatewayDiscovery.this.txt(resolved, "displayName");
                if (strTxt == null) {
                    strTxt = strDecode;
                }
                String strDecode2 = bonjourEscapes.decode(strTxt);
                String strTxt2 = GatewayDiscovery.this.txt(resolved, "lanHost");
                String strTxt3 = GatewayDiscovery.this.txt(resolved, "tailnetDns");
                Integer numTxtInt = GatewayDiscovery.this.txtInt(resolved, "gatewayPort");
                Integer numTxtInt2 = GatewayDiscovery.this.txtInt(resolved, "canvasPort");
                boolean zTxtBool = GatewayDiscovery.this.txtBool(resolved, "gatewayTls");
                String strTxt4 = GatewayDiscovery.this.txt(resolved, "gatewayTlsSha256");
                String strStableId = GatewayDiscovery.this.stableId(strDecode, "local.");
                GatewayDiscovery.this.localById.put(strStableId, new GatewayEndpoint(strStableId, strDecode2, hostAddress, port, strTxt2, strTxt3, numTxtInt, numTxtInt2, zTxtBool, strTxt4));
                GatewayDiscovery.this.publish();
            }
        });
    }

    private final String resolveHostFromMessage(j1 msg, String hostname) {
        InetAddress byAddress;
        if (msg == null) {
            return null;
        }
        List<w2> list = recordsByName(msg, 3).get(keyName(hostname));
        if (list == null) {
            list = s.f1092a;
        }
        ArrayList arrayList = new ArrayList();
        for (w2 w2Var : list) {
            d8.f fVar = w2Var instanceof d8.f ? (d8.f) w2Var : null;
            if (fVar != null) {
                arrayList.add(fVar);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i8 = 0;
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList.get(i9);
            i9++;
            InetAddress inetAddressO = ((d8.f) obj).o();
            String hostAddress = inetAddressO != null ? inetAddressO.getHostAddress() : null;
            if (hostAddress != null) {
                arrayList2.add(hostAddress);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (w2 w2Var2 : list) {
            d8.b bVar = w2Var2 instanceof d8.b ? (d8.b) w2Var2 : null;
            if (bVar != null) {
                arrayList3.add(bVar);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        int size2 = arrayList3.size();
        while (i8 < size2) {
            Object obj2 = arrayList3.get(i8);
            i8++;
            d8.b bVar2 = (d8.b) obj2;
            bVar2.getClass();
            try {
                x1 x1Var = bVar2.f2195a;
                byAddress = x1Var == null ? InetAddress.getByAddress(bVar2.f1941f) : InetAddress.getByAddress(x1Var.toString(), bVar2.f1941f);
            } catch (UnknownHostException unused) {
                byAddress = null;
            }
            String hostAddress2 = byAddress != null ? byAddress.getHostAddress() : null;
            if (hostAddress2 != null) {
                arrayList4.add(hostAddress2);
            }
        }
        String str = (String) m.v0(arrayList2);
        return str == null ? (String) m.v0(arrayList4) : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00bc, code lost:
    
        if (r12 == r1) goto L39;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r11v13, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object resolveHostUnicast(java.lang.String r11, f5.c r12) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.gateway.GatewayDiscovery.resolveHostUnicast(java.lang.String, f5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String stableId(String serviceName, String domain) {
        return this.serviceType + "|" + domain + "|" + normalizeName(serviceName);
    }

    private final void startLocalDiscovery() {
        try {
            this.nsd.discoverServices(this.serviceType, 1, this.discoveryListener);
        } catch (Throwable unused) {
        }
    }

    private final void startUnicastDiscovery(String domain) {
        f0 f0Var = this.scope;
        h6.e eVar = r0.f210a;
        this.unicastJob = i0.q(f0Var, h6.d.f3059c, new C00251(domain, null), 2);
    }

    private final void stopLocalDiscovery() {
        try {
            this.nsd.stopServiceDiscovery(this.discoveryListener);
        } catch (Throwable unused) {
        }
    }

    private final String stripTrailingDot(String raw) {
        return n.C1(raw, ".");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String txt(NsdServiceInfo info, String key) {
        byte[] bArr = info.getAttributes().get(key);
        if (bArr == null) {
            return null;
        }
        try {
            String string = n.T1(new String(bArr, x5.a.f6276a)).toString();
            if (string.length() == 0) {
                return null;
            }
            return string;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean txtBool(NsdServiceInfo info, String key) {
        String string;
        String strTxt = txt(info, key);
        if (strTxt == null || (string = n.T1(strTxt).toString()) == null) {
            return false;
        }
        String lowerCase = string.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.p.d(lowerCase, "toLowerCase(...)");
        return lowerCase.equals("1") || lowerCase.equals("true") || lowerCase.equals("yes");
    }

    private final boolean txtBoolValue(List<? extends a4> records, String key) {
        String string;
        String strTxtValue = txtValue(records, key);
        if (strTxtValue == null || (string = n.T1(strTxtValue).toString()) == null) {
            return false;
        }
        String lowerCase = string.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.p.d(lowerCase, "toLowerCase(...)");
        return lowerCase.equals("1") || lowerCase.equals("true") || lowerCase.equals("yes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Integer txtInt(NsdServiceInfo info, String key) {
        String strTxt = txt(info, key);
        if (strTxt != null) {
            return x5.u.d1(strTxt);
        }
        return null;
    }

    private final Integer txtIntValue(List<? extends a4> records, String key) {
        String strTxtValue = txtValue(records, key);
        if (strTxtValue != null) {
            return x5.u.d1(strTxtValue);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [c5.s] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.ArrayList] */
    private final String txtValue(List<? extends a4> records, String key) {
        ?? arrayList;
        String strN = a8.b.n(key, "=");
        for (a4 a4Var : records) {
            try {
                a4Var.getClass();
                ArrayList arrayList2 = new ArrayList(a4Var.f2249f.size());
                ArrayList arrayList3 = a4Var.f2249f;
                int size = arrayList3.size();
                int i8 = 0;
                while (i8 < size) {
                    Object obj = arrayList3.get(i8);
                    i8++;
                    arrayList2.add(w2.a((byte[]) obj, false));
                }
                arrayList = new ArrayList();
                int size2 = arrayList2.size();
                int i9 = 0;
                while (i9 < size2) {
                    Object obj2 = arrayList2.get(i9);
                    i9++;
                    String str = (String) obj2;
                    if (str == null) {
                        str = null;
                    }
                    if (str != null) {
                        arrayList.add(str);
                    }
                }
            } catch (Throwable unused) {
                arrayList = s.f1092a;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String string = n.T1(decodeDnsTxtString((String) it.next())).toString();
                if (x5.u.c1(string, strN, false)) {
                    String string2 = n.T1(n.B1(string, strN)).toString();
                    if (string2.length() == 0) {
                        return null;
                    }
                    return string2;
                }
            }
        }
        return null;
    }

    public final w getGateways() {
        return this.gateways;
    }

    public final w getStatusText() {
        return this.statusText;
    }
}
