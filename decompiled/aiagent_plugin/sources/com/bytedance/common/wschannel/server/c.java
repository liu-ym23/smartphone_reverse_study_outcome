package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: FrontierMessageManager.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private static final String TAG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile d f7045a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f7046b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f7047c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicBoolean f7048d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static CountDownLatch f7049e;
    private static a f;
    private static Object g;

    /* JADX INFO: compiled from: FrontierMessageManager.java */
    public interface a {
        void a(String r1, JSONObject r2);
    }

    public c() {
    }

    static /* synthetic */ d a(d r0) {
        f7045a = r0;
        return r0;
    }

    static /* synthetic */ Context c() {
        return f7046b;
    }

    static /* synthetic */ d d() {
        return f7045a;
    }

    static {
        f7048d = new AtomicBoolean(false);
        f7049e = new CountDownLatch(1);
        TAG = c.class.getSimpleName();
    }

    public static void a(JSONObject r8) {
        a r0 = f;
        if (r0 == null) goto L10;
        r0.a("frontier_qos2", r8);
    L10:
        Object r1 = g;     // Catch: Throwable -> L9
        if (r1 == null) goto L12;
        Reflect.on(r1).call("monitorLogSend", new Class[]{String.class, JSONObject.class}, new Object[]{"frontier_qos2", r8});     // Catch: Throwable -> L9
        return;
    L12:
        return;
    }

    private static void e() {
        if (f7048d.get() == true) goto L11;
        f7049e.await(WsConstants.EXIT_DELAY_TIME, TimeUnit.MILLISECONDS);     // Catch: Exception -> L8
        if (f7049e.getCount() != 1) goto L12;
        f7049e.countDown();     // Catch: Exception -> L8
        return;
    L12:
        return;
    L13:
        return;
    }

    static void a() {
        f7048d.set(true);
        f7049e.countDown();
    }

    private static Map<String, String> a(List<WsChannelMsg.MsgHeader> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return null;
    L5:
        if (r5.isEmpty() == true) goto L25;
        HashMap r0 = new HashMap();
        Iterator r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L15;
        WsChannelMsg.MsgHeader r2 = (WsChannelMsg.MsgHeader) ZeusTransformUtils.preCheckCast(r6.next(), WsChannelMsg.MsgHeader.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r2.getKey()) == true) goto L9;
        if (TextUtils.isEmpty(r2.getValue()) == true) goto L9;
        r0.put(r2.getKey(), r2.getValue());
        goto L9
    L15:
        return r0;
    L25:
        return null;
    }

    private static boolean a(Map<String, String> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        if (r7.containsKey("x_frontier_qos") == true) goto L5;
    L26:
        return false;
    L5:
        if (r7.containsKey(WsConstants.KEY_FRONTIER_MSGID) == false) goto L26;
        if (r7.containsKey("x_frontier_ttl") == false) goto L26;
        if (r7.get("x_frontier_qos") == null) goto L26;
        if (((String) ZeusTransformUtils.preCheckCast(r7.get("x_frontier_qos"), String.class, "com.obric.aiagent.plugin")).equals("2") == false) goto L26;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r7.get(WsConstants.KEY_FRONTIER_MSGID), String.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r0) == true) goto L26;
        if (r0.getBytes("UTF-8").length != 32) goto L26;
        if (Long.valueOf((String) ZeusTransformUtils.preCheckCast(r7.get("x_frontier_ttl"), String.class, "com.obric.aiagent.plugin")).longValue() > 0) goto L24;
        return false;
    L24:
        return true;
    }

    private static boolean b(Map<String, String> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        if (r8.containsKey("x_frontier_qos") == true) goto L5;
    L31:
        return false;
    L5:
        if (r8.containsKey("x_frontier_qos_ack") == false) goto L31;
        if (r8.containsKey("x_frontier_is_ack") == false) goto L31;
        if (r8.containsKey("x_frontier_ack_msgid") == false) goto L31;
        if (r8.get("x_frontier_qos") == null) goto L31;
        if (((String) ZeusTransformUtils.preCheckCast(r8.get("x_frontier_qos"), String.class, "com.obric.aiagent.plugin")).equals("2") == false) goto L31;
        if (r8.get("x_frontier_qos_ack") == null) goto L31;
        if (((String) ZeusTransformUtils.preCheckCast(r8.get("x_frontier_qos_ack"), String.class, "com.obric.aiagent.plugin")).equals("1") == false) goto L31;
        if (r8.get("x_frontier_is_ack") == null) goto L31;
        if (((String) ZeusTransformUtils.preCheckCast(r8.get("x_frontier_is_ack"), String.class, "com.obric.aiagent.plugin")).equals("1") == false) goto L31;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r8.get("x_frontier_ack_msgid"), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L29;
        return false;
    L29:
        return true;
    }

    private static String[] c(Map<String, String> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if (r6.containsKey("x_frontier_is_ack") == true) goto L5;
    L15:
        return null;
    L5:
        if (r6.containsKey("x_frontier_ack_msgid") == false) goto L15;
        if (((String) ZeusTransformUtils.preCheckCast(r6.get("x_frontier_is_ack"), String.class, "com.obric.aiagent.plugin")).equals("1") == true) goto L11;
        return null;
    L11:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r6.get("x_frontier_ack_msgid"), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L14;
        return null;
    L14:
        return ((String) ZeusTransformUtils.preCheckCast(r6.get("x_frontier_ack_msgid"), String.class, "com.obric.aiagent.plugin")).split(",");
    }

    private static boolean a(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return false;
    L6:
        if (r2.equals("x_frontier_qos") == false) goto L8;
    L15:
        return true;
    L8:
        if (r2.equals(WsConstants.KEY_FRONTIER_MSGID) == true) goto L15;
        if (r2.equals("x_frontier_ttl") == true) goto L15;
        if (r2.equals("x_frontier_ack_msgid") == true) goto L15;
        if (r2.equals("x_frontier_is_ack") == true) goto L15;
        return false;
    }

    private static void b(WsChannelMsg r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.getMsgHeaders() == null) goto L20;
        Iterator<WsChannelMsg.MsgHeader> r4 = r3.getMsgHeaders().iterator();
        if (r4 != null) goto L10;
        return;
    L10:
        if (r4.hasNext() == false) goto L21;
        if (a(((WsChannelMsg.MsgHeader) ZeusTransformUtils.preCheckCast(r4.next(), WsChannelMsg.MsgHeader.class, "com.obric.aiagent.plugin")).getKey()) == false) goto L10;
        r4.remove();
        goto L10
    L21:
        return;
    }

    private static void f() {
        if (g == null) goto L12;
        return;
    L12:
        g = ZeusTransformUtils.forName("com.bytedance.ttnet.TTNetInit", "com.obric.aiagent.plugin").newInstance();     // Catch: Throwable -> L9
        if (Logger.debug() == false) goto L14;
        Logger.d(TAG, "Get TTNetInit instance success.");     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        th = move-exception;
        Logger.e(TAG, "Get TTNetInit instance failed.");
        th.printStackTrace();
    }

    public static boolean a(WsChannelMsg r6) {
        if (f7047c == true) goto L36;
        return false;
    L36:
        Map<String, String> r0 = a(r6.getMsgHeaders());     // Catch: Throwable -> L33
        if (r0 != null) goto L8;
    L32:
        return false;
    L8:
        if (r0.isEmpty() == true) goto L32;
        boolean r2 = b(r0);     // Catch: Throwable -> L33
        boolean r3 = a(r0);     // Catch: Throwable -> L33
        if (r2 == true) goto L14;
        if (r3 == true) goto L14;
        return false;
    L14:
        AtomicBoolean r4 = f7048d;     // Catch: Throwable -> L33
        if (r4.get() == true) goto L18;
        f();     // Catch: Throwable -> L33
        com.bytedance.common.wschannel.e.d.a().a(new AnonymousClass1());     // Catch: Throwable -> L33
        e();     // Catch: Throwable -> L33
    L18:
        if (r4.get() == true) goto L21;
        return false;
    L21:
        if (f7045a != null) goto L24;
        return false;
    L24:
        if (Logger.debug() == false) goto L27;
        Logger.d(TAG, "origin wschannel msg:" + r6.toString());     // Catch: Throwable -> L33
    L27:
        if (r2 == false) goto L30;
        f7045a.a(((String) ZeusTransformUtils.preCheckCast(r0.get("x_frontier_ack_msgid"), String.class, "com.obric.aiagent.plugin")).split(","));     // Catch: Throwable -> L33
        return true;
    L30:
        f7045a.a(c(r0));     // Catch: Throwable -> L33
        b(r6);     // Catch: Throwable -> L33
        return f7045a.a((String) ZeusTransformUtils.preCheckCast(r0.get(WsConstants.KEY_FRONTIER_MSGID), String.class, "com.obric.aiagent.plugin"), Long.valueOf((String) ZeusTransformUtils.preCheckCast(r0.get("x_frontier_ttl"), String.class, "com.obric.aiagent.plugin")).longValue());
    L33:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public static boolean b() {
        return f7047c;
    }
}
