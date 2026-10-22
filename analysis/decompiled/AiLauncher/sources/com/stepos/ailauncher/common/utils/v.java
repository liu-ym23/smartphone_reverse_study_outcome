package com.stepos.ailauncher.common.utils;

import Z8.X;
import Z8.Y;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0010\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\t2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0013\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0003J\u0017\u0010\u0016\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0018\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001a\u0010\u0017J\r\u0010\u001b\u001a\u00020\f¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\f¢\u0006\u0004\b\u001d\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001e\u0010\u0017J\r\u0010\u001f\u001a\u00020\f¢\u0006\u0004\b\u001f\u0010\u001cJ\u0017\u0010 \u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b \u0010\u0017J#\u0010#\u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b'\u0010&R\u0014\u0010(\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b(\u0010&R\u0014\u0010)\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b)\u0010&R\u001c\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R \u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040-0*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010,R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\f0*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010,R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\f0*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010,R\u001c\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010,R \u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040-0*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010,R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010&R\u0018\u00103\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010&R\u0018\u00104\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010&R\u001f\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004058\u0006¢\u0006\f\n\u0004\b\u0005\u00106\u001a\u0004\b7\u00108R#\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040-058\u0006¢\u0006\f\n\u0004\b9\u00106\u001a\u0004\b:\u00108R\u001d\u0010;\u001a\b\u0012\u0004\u0012\u00020\f058\u0006¢\u0006\f\n\u0004\b;\u00106\u001a\u0004\b<\u00108R\u001d\u0010=\u001a\b\u0012\u0004\u0012\u00020\f058\u0006¢\u0006\f\n\u0004\b=\u00106\u001a\u0004\b>\u00108R\u001f\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004058\u0006¢\u0006\f\n\u0004\b?\u00106\u001a\u0004\b@\u00108R#\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040-058\u0006¢\u0006\f\n\u0004\bA\u00106\u001a\u0004\bB\u00108¨\u0006C"}, d2 = {"Lcom/stepos/ailauncher/common/utils/v;", "", "<init>", "()V", "", "sessionId", "", "aliases", "owner", "LY8/t;", "s", "(Ljava/lang/String;Ljava/util/Collection;Ljava/lang/String;)V", "", "visible", "q", "(ZLjava/lang/String;)V", "r", "n", "(Ljava/lang/String;)V", "o", "(Ljava/lang/String;Ljava/util/Collection;)V", "c", "m", "(Ljava/lang/String;)Z", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)V", "p", "k", "()Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "t", "l", "u", "current", "incoming", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)Z", "TAG", "Ljava/lang/String;", "OWNER_ACTIVITY", "OWNER_DETAIL", "OWNER_OVERLAY", "LXa/k;", "_sessionId", "LXa/k;", "", "_keys", "_chatPageForeground", "_conversationBodyForeground", "_hostOwner", "_riskDepartedKeys", "pageOwner", "riskDepartedSessionId", "LXa/t;", "LXa/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()LXa/t;", "keys", Const.INTENT_KEY_BACKGROUND_COMMAND, "chatPageForeground", Const.INTENT_KEY_UMID, "conversationBodyForeground", "e", "hostOwner", "f", "riskDepartedKeys", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class v {
    public static final v INSTANCE = new v();
    public static final String OWNER_ACTIVITY = "ChatActivity";
    public static final String OWNER_DETAIL = "ArtifactDetail";
    public static final String OWNER_OVERLAY = "AgentSpace";
    private static final String TAG = "ForegroundChatSessionTracker";
    private static final Xa.k<Boolean> _chatPageForeground;
    private static final Xa.k<Boolean> _conversationBodyForeground;
    private static final Xa.k<String> _hostOwner;
    private static final Xa.k<Set<String>> _keys;
    private static final Xa.k<Set<String>> _riskDepartedKeys;
    private static final Xa.k<String> _sessionId;
    private static final Xa.t<Boolean> chatPageForeground;
    private static final Xa.t<Boolean> conversationBodyForeground;
    private static final Xa.t<String> hostOwner;
    private static final Xa.t<Set<String>> keys;
    private static String owner;
    private static String pageOwner;
    private static final Xa.t<Set<String>> riskDepartedKeys;
    private static String riskDepartedSessionId;
    private static final Xa.t<String> sessionId;

    static {
        Xa.k<String> kVarA = Xa.u.a(null);
        _sessionId = kVarA;
        Xa.k<Set<String>> kVarA2 = Xa.u.a(Y.e());
        _keys = kVarA2;
        Boolean bool = Boolean.FALSE;
        Xa.k<Boolean> kVarA3 = Xa.u.a(bool);
        _chatPageForeground = kVarA3;
        Xa.k<Boolean> kVarA4 = Xa.u.a(bool);
        _conversationBodyForeground = kVarA4;
        Xa.k<String> kVarA5 = Xa.u.a(null);
        _hostOwner = kVarA5;
        Xa.k<Set<String>> kVarA6 = Xa.u.a(Y.e());
        _riskDepartedKeys = kVarA6;
        sessionId = Xa.d.c(kVarA);
        keys = Xa.d.c(kVarA2);
        chatPageForeground = Xa.d.c(kVarA3);
        conversationBodyForeground = Xa.d.c(kVarA4);
        hostOwner = Xa.d.c(kVarA5);
        riskDepartedKeys = Xa.d.c(kVarA6);
    }

    public final boolean a(String current, String incoming) {
        if (current == null || kotlin.jvm.internal.p.d(incoming, current)) {
            return true;
        }
        return kotlin.jvm.internal.p.d(current, OWNER_DETAIL) ? kotlin.jvm.internal.p.d(incoming, OWNER_DETAIL) : !kotlin.jvm.internal.p.d(current, OWNER_ACTIVITY) || kotlin.jvm.internal.p.d(incoming, OWNER_ACTIVITY) || kotlin.jvm.internal.p.d(incoming, OWNER_DETAIL);
    }

    public final void b(String sessionId2, String owner2) {
        if (!a(owner, owner2)) {
            Log.d(TAG, "ignore clearForegroundSession owner=" + owner2 + " currentOwner=" + owner + " sessionId=" + sessionId2);
            return;
        }
        String str = (sessionId2 == null || sessionId2.length() <= 0) ? null : sessionId2;
        if (str != null && !p(str)) {
            String value = _sessionId.getValue();
            Log.d(TAG, "skip clearForegroundSession unmatched owner=" + owner2 + " requested=" + sessionId2 + " current=" + ((Object) value) + " keys=" + _keys.getValue());
            return;
        }
        String str2 = owner;
        Xa.k<String> kVar = _sessionId;
        String value2 = kVar.getValue();
        Xa.k<Set<String>> kVar2 = _keys;
        Set<String> value3 = kVar2.getValue();
        owner = null;
        _hostOwner.setValue(null);
        kVar.setValue(null);
        kVar2.setValue(Y.e());
        Log.d(TAG, "clearForegroundSession owner=" + owner2 + " prevOwner=" + str2 + " requested=" + sessionId2 + " prevSessionId=" + value2 + " prevKeys=" + value3);
    }

    public final void c() {
        riskDepartedSessionId = null;
        _riskDepartedKeys.setValue(Y.e());
    }

    public final Xa.t<Boolean> d() {
        return chatPageForeground;
    }

    public final Xa.t<Boolean> e() {
        return conversationBodyForeground;
    }

    public final Xa.t<String> f() {
        return hostOwner;
    }

    public final Xa.t<Set<String>> g() {
        return keys;
    }

    public final Xa.t<Set<String>> h() {
        return riskDepartedKeys;
    }

    public final Xa.t<String> i() {
        return sessionId;
    }

    public final boolean j() {
        return _conversationBodyForeground.getValue().booleanValue();
    }

    public final boolean k() {
        return _chatPageForeground.getValue().booleanValue();
    }

    public final boolean l() {
        return kotlin.jvm.internal.p.d(pageOwner, OWNER_DETAIL) && _chatPageForeground.getValue().booleanValue();
    }

    public final boolean m(String sessionId2) {
        if (sessionId2 == null || sessionId2.length() == 0) {
            return false;
        }
        return kotlin.jvm.internal.p.d(sessionId2, riskDepartedSessionId) || _riskDepartedKeys.getValue().contains(sessionId2);
    }

    public final void n(String owner2) {
        if (a(owner, owner2)) {
            owner = owner2;
            _hostOwner.setValue(owner2);
            _sessionId.setValue(null);
            _keys.setValue(Y.e());
        }
    }

    public final void o(String sessionId2, Collection<String> aliases) {
        kotlin.jvm.internal.p.i(aliases, "aliases");
        if (sessionId2 != null) {
            if (sessionId2.length() <= 0) {
                sessionId2 = null;
            }
            if (sessionId2 == null) {
                return;
            }
            riskDepartedSessionId = sessionId2;
            Xa.k<Set<String>> kVar = _riskDepartedKeys;
            Set setB = X.b();
            setB.add(sessionId2);
            for (String str : aliases) {
                if (str.length() > 0) {
                    setB.add(str);
                }
            }
            kVar.setValue(X.a(setB));
        }
    }

    public final boolean p(String sessionId2) {
        if (sessionId2 == null || sessionId2.length() == 0) {
            return false;
        }
        return kotlin.jvm.internal.p.d(sessionId2, _sessionId.getValue()) || _keys.getValue().contains(sessionId2);
    }

    public final void q(boolean visible, String owner2) {
        if (!a(pageOwner, owner2)) {
            Log.d(TAG, "ignore setChatPageForeground owner=" + owner2 + " currentOwner=" + pageOwner + " visible=" + visible);
            return;
        }
        String str = pageOwner;
        Xa.k<Boolean> kVar = _chatPageForeground;
        boolean zBooleanValue = kVar.getValue().booleanValue();
        Xa.k<Boolean> kVar2 = _conversationBodyForeground;
        boolean zBooleanValue2 = kVar2.getValue().booleanValue();
        pageOwner = visible ? owner2 : null;
        kVar.setValue(Boolean.valueOf(visible));
        if (!visible) {
            kVar2.setValue(Boolean.FALSE);
        }
        if (kotlin.jvm.internal.p.d(str, pageOwner) && zBooleanValue == visible && zBooleanValue2 == kVar2.getValue().booleanValue()) {
            return;
        }
        Log.d(TAG, "setChatPageForeground owner=" + owner2 + " prevOwner=" + str + " visible=" + visible + " prevPage=" + zBooleanValue + " body=" + kVar2.getValue() + " prevBody=" + zBooleanValue2);
    }

    public final void r(boolean visible, String owner2) {
        if (!a(pageOwner, owner2)) {
            Log.d(TAG, "ignore setConversationBodyForeground owner=" + owner2 + " currentOwner=" + pageOwner + " visible=" + visible);
            return;
        }
        Xa.k<Boolean> kVar = _conversationBodyForeground;
        boolean zBooleanValue = kVar.getValue().booleanValue();
        kVar.setValue(Boolean.valueOf(visible));
        if (zBooleanValue != visible) {
            Boolean value = _chatPageForeground.getValue();
            String value2 = _sessionId.getValue();
            Log.d(TAG, "setConversationBodyForeground owner=" + owner2 + " visible=" + visible + " prev=" + zBooleanValue + " page=" + value + " sessionId=" + ((Object) value2) + " keys=" + _keys.getValue());
        }
    }

    public final void s(String sessionId2, Collection<String> aliases, String owner2) {
        kotlin.jvm.internal.p.i(aliases, "aliases");
        if (!a(owner, owner2)) {
            Log.d(TAG, "ignore setForegroundSession owner=" + owner2 + " currentOwner=" + owner + " sessionId=" + sessionId2);
            return;
        }
        if (sessionId2 == null || sessionId2.length() <= 0) {
            sessionId2 = null;
        }
        Set setB = X.b();
        if (sessionId2 != null) {
            setB.add(sessionId2);
        }
        for (String str : aliases) {
            if (str.length() > 0) {
                setB.add(str);
            }
        }
        Set<String> setA = X.a(setB);
        String str2 = owner;
        Xa.k<String> kVar = _sessionId;
        String value = kVar.getValue();
        Xa.k<Set<String>> kVar2 = _keys;
        Set<String> value2 = kVar2.getValue();
        owner = owner2;
        _hostOwner.setValue(owner2);
        kVar.setValue(sessionId2);
        kVar2.setValue(setA);
        if (!kotlin.jvm.internal.p.d(str2, owner2) || !kotlin.jvm.internal.p.d(value, sessionId2) || !kotlin.jvm.internal.p.d(value2, setA)) {
            Log.d(TAG, "setForegroundSession owner=" + owner2 + " prevOwner=" + str2 + " prevSessionId=" + value + " sessionId=" + sessionId2 + " prevKeys=" + value2 + " keys=" + setA);
        }
        if (sessionId2 == null || m(sessionId2)) {
            return;
        }
        c();
    }

    public final boolean t(String sessionId2) {
        return j() && p(sessionId2) && !m(sessionId2);
    }

    public final boolean u(String sessionId2) {
        if (l()) {
            return p(sessionId2);
        }
        if (!j()) {
            return false;
        }
        if (_keys.getValue().isEmpty()) {
            return true;
        }
        return p(sessionId2);
    }
}
