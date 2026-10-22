package com.stepos.ability.mcpserver.handshake;

import D7.q;
import D7.v;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import android.os.SystemClock;
import android.util.Log;
import androidx.appfunctions.metadata.a;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.mcpserver.model.McpServerState;
import com.stepos.ability.mcpserver.security.CallerIdentityRegistry$BindResult;
import dagger.hilt.android.EntryPointAccessors;
import h4.AbstractC1487b;
import h4.C1486a;
import i4.C1554b;
import j9.m;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import k4.c;
import k4.d;
import k4.n;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/ability/mcpserver/handshake/McpHandshakeProvider;", "Landroid/content/ContentProvider;", AppAgent.CONSTRUCT, "()V", "server_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class McpHandshakeProvider extends ContentProvider {

    /* renamed from: a, reason: collision with root package name */
    public static final UriMatcher f3191a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        uriMatcher.addURI("com.stepos.ability.mcp", "handshake", 1);
        f3191a = uriMatcher;
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        k.f(uri, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        k.f(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        k.f(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) throws InterruptedException, NoSuchAlgorithmException {
        String str3;
        c cVarA;
        k.f(uri, "uri");
        if (f3191a.match(uri) != 1) {
            Log.w("McpHandshakeProvider", "Unknown uri path");
            return null;
        }
        Context context = getContext();
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        k.e(applicationContext, "getApplicationContext(...)");
        McpHandshakeEntryPoint mcpHandshakeEntryPoint = (McpHandshakeEntryPoint) EntryPointAccessors.fromApplication(applicationContext, McpHandshakeEntryPoint.class);
        int callingUid = Binder.getCallingUid();
        if (callingUid % AndroidComposeViewAccessibilityDelegateCompat.ParcelSafeTextLength < 10000) {
            Log.w("McpHandshakeProvider", "Handshake denied: non-app uid=" + callingUid);
            return null;
        }
        C1486a c1486aHandshakeGate = mcpHandshakeEntryPoint.handshakeGate();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!c1486aHandshakeGate.f4561a.a(jCurrentTimeMillis, "uid:" + callingUid)) {
            long jIncrementAndGet = c1486aHandshakeGate.b.incrementAndGet();
            if (jIncrementAndGet % 100 == 1) {
                Log.w("HandshakeGate", "handshake throttled: uid=" + callingUid + " (total=" + jIncrementAndGet + ")");
            }
            mcpHandshakeEntryPoint.monitor().k.incrementAndGet();
            return null;
        }
        C1554b c1554bMonitor = mcpHandshakeEntryPoint.monitor();
        long jElapsedRealtime = SystemClock.elapsedRealtime() + 2000;
        McpServerState mcpServerState = c1554bMonitor.b;
        while ((mcpServerState instanceof McpServerState.NotStarted) && SystemClock.elapsedRealtime() < jElapsedRealtime) {
            try {
                Thread.sleep(50L);
                mcpServerState = c1554bMonitor.b;
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        if (!(mcpServerState instanceof McpServerState.Running)) {
            Log.e("McpHandshakeProvider", "Handshake refused: server not running, state=" + mcpServerState);
            return null;
        }
        McpServerState.Running running = (McpServerState.Running) mcpServerState;
        Log.d("McpHandshakeProvider", "Handshake granted: uid=" + callingUid + " port=" + running.getPort());
        if (k.b(str, "api_key") && strArr2 != null && (str3 = (String) q.n0(strArr2)) != null) {
            if (m.s0(str3)) {
                str3 = null;
            }
            if (str3 != null) {
                d dVarIdentityResolver = mcpHandshakeEntryPoint.identityResolver();
                String[] packagesForUid = dVarIdentityResolver.f4798a.getPackageManager().getPackagesForUid(callingUid);
                String str4 = packagesForUid != null ? (String) q.n0(packagesForUid) : null;
                if (str4 == null) {
                    Log.w("AppIdentityResolver", "no package for uid=" + callingUid);
                    cVarA = null;
                } else {
                    if (packagesForUid.length > 1) {
                        StringBuilder sbS = a.s(callingUid, "uid=", packagesForUid.length, " maps to ", " packages, using ");
                        sbS.append(str4);
                        Log.w("AppIdentityResolver", sbS.toString());
                    }
                    cVarA = dVarIdentityResolver.a(str4);
                }
                if (cVarA == null) {
                    Log.w("McpHandshakeProvider", "cannot resolve identity for uid=" + callingUid + ", no binding established");
                } else {
                    n nVarIdentityRegistry = mcpHandshakeEntryPoint.identityRegistry();
                    nVarIdentityRegistry.getClass();
                    String strB = n.b(str3);
                    synchronized (nVarIdentityRegistry.b) {
                        Object obj = nVarIdentityRegistry.d.get(strB);
                        if (obj != null && ((k4.m) obj).b == callingUid && ((k4.m) obj).f4807a.equals(cVarA)) {
                            CallerIdentityRegistry$BindResult callerIdentityRegistry$BindResult = CallerIdentityRegistry$BindResult.f3201a;
                        } else {
                            k4.m mVar = (k4.m) obj;
                            if (mVar != null) {
                                nVarIdentityRegistry.a(mVar.b, strB);
                            }
                            nVarIdentityRegistry.d.put(strB, new k4.m(cVarA, callingUid));
                            HashMap map = nVarIdentityRegistry.c;
                            Integer numValueOf = Integer.valueOf(callingUid);
                            Object linkedHashSet = map.get(numValueOf);
                            if (linkedHashSet == null) {
                                linkedHashSet = new LinkedHashSet();
                                map.put(numValueOf, linkedHashSet);
                            }
                            LinkedHashSet linkedHashSet2 = (LinkedHashSet) linkedHashSet;
                            linkedHashSet2.add(strB);
                            while (linkedHashSet2.size() > nVarIdentityRegistry.f4808a) {
                                String str5 = (String) v.z0(linkedHashSet2);
                                linkedHashSet2.remove(str5);
                                nVarIdentityRegistry.d.remove(str5);
                            }
                            int iOrdinal = (obj == null ? CallerIdentityRegistry$BindResult.f3201a : CallerIdentityRegistry$BindResult.b).ordinal();
                            if (iOrdinal == 0) {
                                Log.i("CallerIdentityRegistry", "bound identity: package=" + cVarA.f4797a + " uid=" + callingUid);
                            } else if (iOrdinal != 1) {
                                if (iOrdinal != 2) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                k4.m mVar2 = (k4.m) obj;
                                String str6 = mVar2 != null ? mVar2.f4807a.f4797a : null;
                                Integer numValueOf2 = mVar2 != null ? Integer.valueOf(mVar2.b) : null;
                                Log.w("CallerIdentityRegistry", "key REBOUND: package=" + str6 + " uid=" + numValueOf2 + " -> package=" + cVarA.f4797a + " uid=" + callingUid + " (possible key leak / binding hijack)");
                            }
                        }
                    }
                }
            }
        }
        MatrixCursor matrixCursor = new MatrixCursor(AbstractC1487b.f4562a);
        matrixCursor.addRow(new Object[]{Integer.valueOf(running.getPort()), mcpHandshakeEntryPoint.serverNonce().f4820a});
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        k.f(uri, "uri");
        return 0;
    }
}
