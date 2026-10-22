package com.stepos.ailauncher.foundation.account;

import Y8.t;
import Z8.F;
import Z8.r;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.OnAccountsUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import net.sqlcipher.database.SQLiteDatabase;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u0003J\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001d\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010#\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u001aH\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u001aH\u0002¢\u0006\u0004\b%\u0010\u001cJ#\u0010)\u001a\u0004\u0018\u00010\u001a2\u0006\u0010&\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010'H\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0006H\u0002¢\u0006\u0004\b+\u0010\u0003J\u0015\u0010-\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0004¢\u0006\u0004\b-\u0010\bJ\r\u0010.\u001a\u00020\u0006¢\u0006\u0004\b.\u0010\u0003J\r\u0010/\u001a\u00020\"¢\u0006\u0004\b/\u00100J\u0015\u00101\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b1\u0010\u000eJ\u0015\u00102\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b2\u0010\u000eJ\r\u00103\u001a\u00020\"¢\u0006\u0004\b3\u00100J\u001f\u00105\u001a\u00020\u00062\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u00104\u001a\u00020\u0001¢\u0006\u0004\b5\u00106J%\u00107\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010&\u001a\u00020\"2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b7\u0010*J\u001d\u00109\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u001a2\u0006\u00104\u001a\u000208¢\u0006\u0004\b9\u0010:J\u000f\u0010<\u001a\u0004\u0018\u00010;¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b>\u0010\u0015J\u0019\u0010@\u001a\u00020\u00062\b\u0010?\u001a\u0004\u0018\u00010;H\u0016¢\u0006\u0004\b@\u0010AJ+\u0010F\u001a\u00020\u00062\u0006\u0010C\u001a\u00020B2\b\u0010D\u001a\u0004\u0018\u00010\u001a2\b\u0010E\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\bF\u0010GJ#\u0010I\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\u001a2\b\u0010H\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\bI\u0010JJ\r\u0010K\u001a\u00020\u001a¢\u0006\u0004\bK\u0010\u001cR\u0014\u0010L\u001a\u00020\u001a8\u0002X\u0082T¢\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010O\u001a\u00020N8\u0002X\u0082T¢\u0006\u0006\n\u0004\bO\u0010\rR\"\u0010P\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u00100\"\u0004\bS\u0010TR\u001a\u0010V\u001a\b\u0012\u0004\u0012\u00020\u000b0U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010X\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010Z\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010QR\u0014\u0010\\\u001a\u00020[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010_\u001a\u00020^8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010aR\u001b\u0010g\u001a\u00020b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010fR\u0016\u0010h\u001a\u00020N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010\r¨\u0006i"}, d2 = {"Lcom/stepos/ailauncher/foundation/account/f;", "Lcom/stepos/ailauncher/foundation/account/j;", "<init>", "()V", "Landroid/content/Context;", "appContext", "LY8/t;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Landroid/content/Context;)V", "M", "w", "Lcom/stepos/ailauncher/foundation/account/i;", "callback", "J", "(Lcom/stepos/ailauncher/foundation/account/i;)V", "K", "", "H", "()Ljava/util/List;", "Lcom/stepos/ailauncher/foundation/account/a;", "I", "()Lcom/stepos/ailauncher/foundation/account/a;", "info", "L", "(Lcom/stepos/ailauncher/foundation/account/a;)V", "G", "", "x", "()Ljava/lang/String;", "y", "accountId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;)V", M5.b.CREDENTIAL_TOKEN, "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;Ljava/lang/String;)Z", "F", "invalidateToken", "Landroid/app/Activity;", "activity", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(ZLandroid/app/Activity;)Ljava/lang/String;", "t", "context", "s", "D", "u", "()Z", "z", "C", "v", "listener", "m", "(Landroid/app/Activity;Lcom/stepos/ailauncher/foundation/account/j;)V", "n", "Lcom/stepos/ailauncher/foundation/account/k;", "r", "(Ljava/lang/String;Lcom/stepos/ailauncher/foundation/account/k;)V", "Landroid/content/Intent;", "p", "()Landroid/content/Intent;", "l", "intent", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Intent;)V", "", "code", C3081a.ERROR_MSG, "accountName", "c", "(ILjava/lang/String;Ljava/lang/String;)V", "secret", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)V", "k", "TAG", "Ljava/lang/String;", "", "LOGIN_LAUNCH_DEBOUNCE_MS", "DEBUG_FORCE_INVALID_TOKEN", "Z", "getDEBUG_FORCE_INVALID_TOKEN", "setDEBUG_FORCE_INVALID_TOKEN", "(Z)V", "", "mAccountCallbacks", "Ljava/util/List;", "mAccountInfo", "Lcom/stepos/ailauncher/foundation/account/a;", "identityResolved", "", "tokenFetchLock", "Ljava/lang/Object;", "Lcom/stepos/ailauncher/foundation/account/h;", "authenticatorManager", "Lcom/stepos/ailauncher/foundation/account/h;", "Landroid/content/Context;", "Landroid/os/Handler;", "systemAccountsHandler$delegate", "LY8/h;", "q", "()Landroid/os/Handler;", "systemAccountsHandler", "lastLoginLaunchAt", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class f implements j {
    private static volatile boolean DEBUG_FORCE_INVALID_TOKEN = false;
    private static final long LOGIN_LAUNCH_DEBOUNCE_MS = 2000;
    private static final String TAG = "AccountManager";
    private static Context appContext;
    private static h authenticatorManager;
    private static boolean identityResolved;
    private static volatile long lastLoginLaunchAt;
    private static AccountInfo mAccountInfo;
    public static final f INSTANCE = new f();
    private static final List<i> mAccountCallbacks = new ArrayList();
    private static final Object tokenFetchLock = new Object();

    /* renamed from: systemAccountsHandler$delegate, reason: from kotlin metadata */
    private static final Y8.h systemAccountsHandler = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.foundation.account.b
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return f.O();
        }
    });

    public static final void B(Account[] accountArr) {
        INSTANCE.w();
    }

    public static final void E() {
        Object objB;
        Object objB2;
        Object objB3;
        Object objB4;
        f fVar = INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            String strX = fVar.x();
            Object obj = null;
            if (strX == null || strX.length() <= 0) {
                strX = null;
            }
            String str = "";
            if (strX == null) {
                strX = "";
            }
            try {
                h hVar = authenticatorManager;
                if (hVar == null) {
                    p.A("authenticatorManager");
                    hVar = null;
                }
                objB2 = Result.b(hVar.a());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th));
            }
            if (Result.g(objB2)) {
                objB2 = null;
            }
            String str2 = (String) objB2;
            if (str2 == null) {
                str2 = "";
            }
            boolean z10 = true;
            if (str2.length() == 0) {
                if (strX.length() == 0) {
                    fVar.h("");
                }
                if (strX.length() <= 0) {
                    z10 = false;
                }
                Log.i(TAG, "reresolve: still empty, prevHadUid=" + z10);
            } else if (p.d(str2, strX)) {
                String strY = fVar.y();
                if (strY == null || strY.length() == 0) {
                    try {
                        h hVar2 = authenticatorManager;
                        if (hVar2 == null) {
                            p.A("authenticatorManager");
                            hVar2 = null;
                        }
                        String[] strArrC = hVar2.c(false, null);
                        objB4 = Result.b(strArrC != null ? (String) r.j0(strArrC, 0) : null);
                    } catch (Throwable th2) {
                        Result.Companion companion3 = Result.INSTANCE;
                        objB4 = Result.b(C4849c.a(th2));
                    }
                    if (!Result.g(objB4)) {
                        obj = objB4;
                    }
                    String str3 = (String) obj;
                    if (str3 != null) {
                        str = str3;
                    }
                    fVar.i(str2, str);
                }
                Log.d(TAG, "reresolve: uid unchanged, skip callback");
            } else {
                fVar.h(str2);
                try {
                    h hVar3 = authenticatorManager;
                    if (hVar3 == null) {
                        p.A("authenticatorManager");
                        hVar3 = null;
                    }
                    String[] strArrC2 = hVar3.c(false, null);
                    objB3 = Result.b(strArrC2 != null ? (String) r.j0(strArrC2, 0) : null);
                } catch (Throwable th3) {
                    Result.Companion companion4 = Result.INSTANCE;
                    objB3 = Result.b(C4849c.a(th3));
                }
                if (!Result.g(objB3)) {
                    obj = objB3;
                }
                String str4 = (String) obj;
                if (str4 != null) {
                    str = str4;
                }
                if (fVar.i(str2, str)) {
                    if (strX.length() != 0) {
                        z10 = false;
                    }
                    Log.i(TAG, "reresolve: uid available prevEmpty=" + z10 + ", notify callbacks");
                    fVar.t();
                }
            }
            objB = Result.b(t.f7040a);
        } catch (Throwable th4) {
            Result.Companion companion5 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th4));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "reresolveIdentityFromSdk failed", thE);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x006c A[Catch: all -> 0x0013, TryCatch #0 {all -> 0x0013, blocks: (B:3:0x0004, B:5:0x000c, B:71:0x00dc, B:10:0x0016, B:12:0x001e, B:16:0x0027, B:19:0x0032, B:38:0x0066, B:40:0x006c, B:41:0x0071, B:54:0x009c, B:58:0x00a4, B:62:0x00aa, B:64:0x00b0, B:68:0x00b8, B:70:0x00d9, B:53:0x0092, B:32:0x005a, B:35:0x0061, B:31:0x0050, B:24:0x003c, B:26:0x0040, B:29:0x0047, B:42:0x0074, B:44:0x0078, B:47:0x007f, B:49:0x0085, B:51:0x008d), top: B:78:0x0004, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0071 A[Catch: all -> 0x0013, TRY_LEAVE, TryCatch #0 {all -> 0x0013, blocks: (B:3:0x0004, B:5:0x000c, B:71:0x00dc, B:10:0x0016, B:12:0x001e, B:16:0x0027, B:19:0x0032, B:38:0x0066, B:40:0x006c, B:41:0x0071, B:54:0x009c, B:58:0x00a4, B:62:0x00aa, B:64:0x00b0, B:68:0x00b8, B:70:0x00d9, B:53:0x0092, B:32:0x005a, B:35:0x0061, B:31:0x0050, B:24:0x003c, B:26:0x0040, B:29:0x0047, B:42:0x0074, B:44:0x0078, B:47:0x007f, B:49:0x0085, B:51:0x008d), top: B:78:0x0004, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void N() {
        /*
            Method dump skipped, instructions count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.account.f.N():void");
    }

    public static final Handler O() {
        HandlerThread handlerThread = new HandlerThread("AccountSystemListener");
        handlerThread.start();
        return new Handler(handlerThread.getLooper());
    }

    public static /* synthetic */ String o(f fVar, boolean z10, Activity activity, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            activity = null;
        }
        return fVar.n(z10, activity);
    }

    public final void A(Context appContext2) {
        try {
            AccountManager accountManager = AccountManager.get(appContext2);
            if (accountManager == null) {
                return;
            }
            accountManager.addOnAccountsUpdatedListener(new OnAccountsUpdateListener() { // from class: com.stepos.ailauncher.foundation.account.c
                @Override // android.accounts.OnAccountsUpdateListener
                public final void onAccountsUpdated(Account[] accountArr) {
                    f.B(accountArr);
                }
            }, q(), false);
            Log.i(TAG, "system OnAccountsUpdatedListener registered");
            M();
        } catch (SecurityException e10) {
            Log.w(TAG, "registerSystemAccountsListener: missing GET_ACCOUNTS permission?", e10);
        } catch (Throwable th) {
            Log.w(TAG, "registerSystemAccountsListener failed", th);
        }
    }

    public final void C(i callback) {
        p.i(callback, "callback");
        K(callback);
    }

    public final void D() {
        if (authenticatorManager == null) {
            return;
        }
        q().post(new Runnable() { // from class: com.stepos.ailauncher.foundation.account.e
            @Override // java.lang.Runnable
            public final void run() {
                f.E();
            }
        });
    }

    public final String F() {
        Object objB;
        if (authenticatorManager == null) {
            return "";
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            h hVar = authenticatorManager;
            if (hVar == null) {
                p.A("authenticatorManager");
                hVar = null;
            }
            objB = Result.b(hVar.a());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        String str = (String) (Result.g(objB) ? null : objB);
        String str2 = str != null ? str : "";
        h(str2);
        return str2;
    }

    public final synchronized void G() {
        mAccountInfo = null;
        identityResolved = true;
    }

    public final synchronized List<i> H() {
        return F.m1(mAccountCallbacks);
    }

    public final synchronized AccountInfo I() {
        AccountInfo accountInfo;
        accountInfo = mAccountInfo;
        return accountInfo != null ? AccountInfo.b(accountInfo, null, null, 3, null) : null;
    }

    public final synchronized void J(i callback) {
        List<i> list = mAccountCallbacks;
        if (!list.contains(callback)) {
            list.add(callback);
        }
    }

    public final synchronized void K(i callback) {
        mAccountCallbacks.remove(callback);
    }

    public final synchronized void L(AccountInfo info) {
        mAccountInfo = info;
        identityResolved = true;
    }

    public final void M() {
        q().post(new Runnable() { // from class: com.stepos.ailauncher.foundation.account.d
            @Override // java.lang.Runnable
            public final void run() {
                f.N();
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    @Override // com.stepos.ailauncher.foundation.account.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            r0 = 0
            java.lang.String r1 = "AccountManager"
            r2 = 1
            if (r5 == 0) goto L67
            int r3 = r5.length()
            if (r3 != 0) goto Ld
            goto L67
        Ld:
            if (r6 == 0) goto L15
            int r6 = r6.length()
            if (r6 != 0) goto L16
        L15:
            r0 = r2
        L16:
            r6 = r0 ^ 1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "onSuccess >>> hasToken:true , hasSecret:"
            r0.append(r2)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            android.util.Log.d(r1, r6)
            java.lang.String r6 = r4.x()
            r0 = 0
            if (r6 == 0) goto L3d
            int r2 = r6.length()
            if (r2 <= 0) goto L3a
            goto L3b
        L3a:
            r6 = r0
        L3b:
            if (r6 != 0) goto L4c
        L3d:
            com.stepos.ailauncher.foundation.account.h r6 = com.stepos.ailauncher.foundation.account.f.authenticatorManager
            if (r6 != 0) goto L47
            java.lang.String r6 = "authenticatorManager"
            kotlin.jvm.internal.p.A(r6)
            goto L48
        L47:
            r0 = r6
        L48:
            java.lang.String r6 = r0.a()
        L4c:
            if (r6 == 0) goto L61
            int r0 = r6.length()
            if (r0 != 0) goto L55
            goto L61
        L55:
            com.stepos.ailauncher.foundation.account.a r0 = new com.stepos.ailauncher.foundation.account.a
            r0.<init>(r6, r5)
            r4.L(r0)
            r4.t()
            return
        L61:
            java.lang.String r4 = "onSuccess >>> hasToken but accountId empty, skip cache"
            android.util.Log.e(r1, r4)
            return
        L67:
            if (r6 == 0) goto L6f
            int r4 = r6.length()
            if (r4 != 0) goto L70
        L6f:
            r0 = r2
        L70:
            r4 = r0 ^ 1
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "onSuccess >>> token is null/empty, hasSecret:"
            r5.append(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            android.util.Log.e(r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.account.f.a(java.lang.String, java.lang.String):void");
    }

    @Override // com.stepos.ailauncher.foundation.account.j
    public void b(Intent intent) {
        Log.i(TAG, "onHandleIntent >>> " + intent);
        if (intent == null) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (jUptimeMillis - lastLoginLaunchAt < 2000) {
            Log.w(TAG, "onHandleIntent: skip duplicate login launch within 2000ms");
            return;
        }
        Context context = appContext;
        if (context == null) {
            Log.w(TAG, "onHandleIntent: appContext is null, AccountManager not init'd yet");
            return;
        }
        try {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            lastLoginLaunchAt = jUptimeMillis;
            context.startActivity(intent);
        } catch (Throwable th) {
            Log.w(TAG, "onHandleIntent: startActivity failed", th);
        }
    }

    @Override // com.stepos.ailauncher.foundation.account.j
    public void c(int code, String errorMsg, String accountName) {
        Log.e(TAG, "onError >>> code: " + code + " , errorMsg : " + errorMsg + " , hasAccountName:" + (accountName != null));
    }

    public final synchronized void h(String accountId) {
        identityResolved = true;
        if (accountId.length() == 0) {
            mAccountInfo = null;
            return;
        }
        AccountInfo accountInfo = mAccountInfo;
        if (accountInfo == null || !p.d(accountInfo.getAccountId(), accountId)) {
            mAccountInfo = new AccountInfo(accountId, "");
        }
    }

    public final synchronized boolean i(String accountId, String token) {
        AccountInfo accountInfo = mAccountInfo;
        if (accountInfo == null) {
            return false;
        }
        if (!p.d(accountInfo.getAccountId(), accountId)) {
            return false;
        }
        if (token.length() > 0) {
            mAccountInfo = AccountInfo.b(accountInfo, null, token, 1, null);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x004f, code lost:
    
        if (r1.i(r2, r5) == false) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x001f A[Catch: all -> 0x0015, TryCatch #0 {, blocks: (B:8:0x000b, B:14:0x0017, B:16:0x001f, B:17:0x0023, B:19:0x0027, B:20:0x002d, B:22:0x0033, B:25:0x003d, B:28:0x0044, B:31:0x004b), top: B:39:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0027 A[Catch: all -> 0x0015, TryCatch #0 {, blocks: (B:8:0x000b, B:14:0x0017, B:16:0x001f, B:17:0x0023, B:19:0x0027, B:20:0x002d, B:22:0x0033, B:25:0x003d, B:28:0x0044, B:31:0x004b), top: B:39:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0033 A[Catch: all -> 0x0015, TryCatch #0 {, blocks: (B:8:0x000b, B:14:0x0017, B:16:0x001f, B:17:0x0023, B:19:0x0027, B:20:0x002d, B:22:0x0033, B:25:0x003d, B:28:0x0044, B:31:0x004b), top: B:39:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004b A[Catch: all -> 0x0015, TRY_LEAVE, TryCatch #0 {, blocks: (B:8:0x000b, B:14:0x0017, B:16:0x001f, B:17:0x0023, B:19:0x0027, B:20:0x002d, B:22:0x0033, B:25:0x003d, B:28:0x0044, B:31:0x004b), top: B:39:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String j(boolean r5, android.app.Activity r6) {
        /*
            r4 = this;
            com.stepos.ailauncher.foundation.account.h r4 = com.stepos.ailauncher.foundation.account.f.authenticatorManager
            r0 = 0
            if (r4 != 0) goto L6
            return r0
        L6:
            java.lang.Object r4 = com.stepos.ailauncher.foundation.account.f.tokenFetchLock
            monitor-enter(r4)
            if (r5 != 0) goto L17
            com.stepos.ailauncher.foundation.account.f r1 = com.stepos.ailauncher.foundation.account.f.INSTANCE     // Catch: java.lang.Throwable -> L15
            java.lang.String r1 = r1.y()     // Catch: java.lang.Throwable -> L15
            if (r1 == 0) goto L17
            monitor-exit(r4)
            return r1
        L15:
            r5 = move-exception
            goto L55
        L17:
            com.stepos.ailauncher.foundation.account.f r1 = com.stepos.ailauncher.foundation.account.f.INSTANCE     // Catch: java.lang.Throwable -> L15
            java.lang.String r2 = r1.x()     // Catch: java.lang.Throwable -> L15
            if (r2 != 0) goto L23
            java.lang.String r2 = r1.F()     // Catch: java.lang.Throwable -> L15
        L23:
            com.stepos.ailauncher.foundation.account.h r3 = com.stepos.ailauncher.foundation.account.f.authenticatorManager     // Catch: java.lang.Throwable -> L15
            if (r3 != 0) goto L2d
            java.lang.String r3 = "authenticatorManager"
            kotlin.jvm.internal.p.A(r3)     // Catch: java.lang.Throwable -> L15
            r3 = r0
        L2d:
            java.lang.String[] r5 = r3.c(r5, r6)     // Catch: java.lang.Throwable -> L15
            if (r5 == 0) goto L3a
            java.lang.Object r5 = Z8.r.Z(r5)     // Catch: java.lang.Throwable -> L15
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L15
            goto L3b
        L3a:
            r5 = r0
        L3b:
            if (r5 == 0) goto L53
            int r6 = r5.length()     // Catch: java.lang.Throwable -> L15
            if (r6 != 0) goto L44
            goto L53
        L44:
            int r6 = r2.length()     // Catch: java.lang.Throwable -> L15
            if (r6 != 0) goto L4b
            goto L51
        L4b:
            boolean r6 = r1.i(r2, r5)     // Catch: java.lang.Throwable -> L15
            if (r6 != 0) goto L53
        L51:
            monitor-exit(r4)
            return r0
        L53:
            monitor-exit(r4)
            return r5
        L55:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.account.f.j(boolean, android.app.Activity):java.lang.String");
    }

    public final String k() {
        if (authenticatorManager == null) {
            return "";
        }
        String strX = x();
        return strX != null ? strX : F();
    }

    public final AccountInfo l() {
        if (!v()) {
            return null;
        }
        AccountInfo accountInfoI = I();
        if (accountInfoI != null && accountInfoI.getToken().length() > 0) {
            return accountInfoI;
        }
        o(this, false, null, 3, null);
        return I();
    }

    public final void m(Activity activity, j listener) {
        p.i(listener, "listener");
        h hVar = authenticatorManager;
        if (hVar == null) {
            p.A("authenticatorManager");
            hVar = null;
        }
        hVar.b(false, activity, listener);
    }

    public final String n(boolean invalidateToken, Activity activity) {
        String strY;
        if (!DEBUG_FORCE_INVALID_TOKEN) {
            return (invalidateToken || (strY = y()) == null) ? j(invalidateToken, activity) : strY;
        }
        String str = "DEBUG_INVALID_TOKEN_" + System.currentTimeMillis();
        C4148a.s("TOKEN_DEBUG", "force invalid token (invalidate=" + invalidateToken + ") -> " + str, true);
        return str;
    }

    public final Intent p() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            h hVar = authenticatorManager;
            if (hVar == null) {
                p.A("authenticatorManager");
                hVar = null;
            }
            objB = Result.b(hVar.d());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (Intent) (Result.g(objB) ? null : objB);
    }

    public final Handler q() {
        return (Handler) systemAccountsHandler.getValue();
    }

    public final void r(String token, k listener) {
        p.i(token, "token");
        p.i(listener, "listener");
        h hVar = authenticatorManager;
        if (hVar == null) {
            p.A("authenticatorManager");
            hVar = null;
        }
        hVar.e(token, true, listener);
    }

    public final void s(Context context) {
        p.i(context, "context");
        try {
            appContext = context.getApplicationContext();
            authenticatorManager = new h(context);
            F();
            Context applicationContext = context.getApplicationContext();
            p.h(applicationContext, "getApplicationContext(...)");
            A(applicationContext);
        } catch (Throwable th) {
            Log.e(TAG, "init account sdk error", th);
        }
    }

    public final void t() {
        Iterator<T> it = H().iterator();
        while (it.hasNext()) {
            try {
                ((i) it.next()).a(INSTANCE.I());
            } catch (Exception e10) {
                Log.e(TAG, "Callback execution failed: " + e10.getMessage());
            }
        }
    }

    public final boolean u() {
        boolean z10;
        if (authenticatorManager == null) {
            return false;
        }
        synchronized (this) {
            z10 = identityResolved;
        }
        return z10;
    }

    public final boolean v() {
        if (authenticatorManager == null) {
            return false;
        }
        String strX = x();
        return strX != null ? strX.length() > 0 : F().length() > 0;
    }

    public final void w() {
        Object objB;
        Object objB2;
        try {
            Result.Companion companion = Result.INSTANCE;
            h hVar = authenticatorManager;
            if (hVar == null) {
                p.A("authenticatorManager");
                hVar = null;
            }
            objB = Result.b(hVar.a());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        String str = (String) objB;
        if (str == null) {
            str = "";
        }
        boolean z10 = str.length() > 0;
        AccountInfo accountInfoI = I();
        String accountId = accountInfoI != null ? accountInfoI.getAccountId() : null;
        if (accountId == null) {
            accountId = "";
        }
        if (!z10 || str.length() == 0) {
            if (accountId.length() == 0) {
                return;
            }
            Log.i(TAG, "system accounts changed: logged out, prev=" + accountId);
            G();
            t();
            return;
        }
        if (p.d(str, accountId)) {
            return;
        }
        Log.i(TAG, "system accounts changed: switched " + accountId + " -> " + str);
        h(str);
        try {
            h hVar2 = authenticatorManager;
            if (hVar2 == null) {
                p.A("authenticatorManager");
                hVar2 = null;
            }
            String[] strArrC = hVar2.c(false, null);
            objB2 = Result.b(strArrC != null ? (String) r.j0(strArrC, 0) : null);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        String str2 = (String) (Result.g(objB2) ? null : objB2);
        if (i(str, str2 != null ? str2 : "")) {
            t();
        }
    }

    public final synchronized String x() {
        try {
            if (!identityResolved) {
                return null;
            }
            AccountInfo accountInfo = mAccountInfo;
            String accountId = accountInfo != null ? accountInfo.getAccountId() : null;
            if (accountId == null) {
                accountId = "";
            }
            return accountId;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized String y() {
        String str;
        String token;
        AccountInfo accountInfo = mAccountInfo;
        str = null;
        if (accountInfo != null && (token = accountInfo.getToken()) != null) {
            if (token.length() > 0) {
                str = token;
            }
        }
        return str;
    }

    public final void z(i callback) {
        p.i(callback, "callback");
        J(callback);
    }
}
