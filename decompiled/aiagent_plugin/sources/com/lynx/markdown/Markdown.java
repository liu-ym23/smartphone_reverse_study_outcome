package com.lynx.markdown;

import android.util.Log;
import com.ttreader.tttext.lite.TTText;
import com.ttreader.tttext.lite.TTTextDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes2.dex */
public class Markdown {
    private static final long TIMEOUT = 5;
    private static volatile boolean mInitializeStarted = false;
    private static volatile boolean mInitialized = false;
    private static final CountDownLatch mInitializedLatch = null;

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.i(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.e(r0, r1);
    }

    public Markdown() {
    }

    public static void init(a r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
        if (mInitializeStarted == false) goto L6;
        return;
    L6:
        monitor-enter(Markdown.class);
    L26:
        th = move-exception;
        throw th;
    L8:
        if (mInitializeStarted == false) goto L11;
        monitor-exit(Markdown.class);     // Catch: Throwable -> L26
        return;
    L11:
        mInitializeStarted = true;     // Catch: Throwable -> L26
        monitor-exit(Markdown.class);     // Catch: Throwable -> L26
        if (r5 == null) goto L15;
        r5.a("serval_markdown");     // Catch: Throwable -> L18 Exception -> L20
    L16:
        TTText.Initial();     // Catch: Throwable -> L18 Exception -> L20
        MarkdownParser.initial();     // Catch: Throwable -> L18 Exception -> L20
        ZeusTransformUtils.forName(TTTextDefinition.class.getName(), "com.obric.aiagent.plugin");     // Catch: Throwable -> L18 Exception -> L20
        INVOKESTATIC_com_lynx_markdown_Markdown_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i("Markdown", "MarkdownParser warm:" + new MarkdownParser(null, null).hashCode());     // Catch: Throwable -> L18 Exception -> L20
    L22:
        mInitialized = true;
        mInitializedLatch.countDown();
        return;
    L15:
        System.loadLibrary("serval_markdown");     // Catch: Throwable -> L18 Exception -> L20
    L20:
        e = move-exception;
        INVOKESTATIC_com_lynx_markdown_Markdown_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("Markdown", "load library fail: " + e.toString());     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        mInitialized = true;
        mInitializedLatch.countDown();
        throw th;
    }

    static {
        mInitializedLatch = new CountDownLatch(1);
    }

    public static void ensureInitialized() {
        if (mInitialized == false) goto L13;
        return;
    L13:
        init(null);     // Catch: InterruptedException -> L10
        if (mInitializedLatch.await(5, TimeUnit.SECONDS) == false) goto L9;
        return;
    L9:
        throw new RuntimeException("Markdown initialization timed out.");     // Catch: InterruptedException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_lynx_markdown_Markdown_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_lynx_markdown_Markdown_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
