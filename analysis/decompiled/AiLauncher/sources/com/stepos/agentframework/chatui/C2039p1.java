package com.stepos.agentframework.chatui;

import La.C0953c;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/agentframework/chatui/p1;", "Lcom/stepos/agentframework/chatui/s2;", "", "fileName", "<init>", "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Le9/c;)Ljava/lang/Object;", "Ljava/lang/String;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatui.p1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2039p1 implements s2 {
    private final String fileName;

    public C2039p1(String fileName) {
        kotlin.jvm.internal.p.i(fileName, "fileName");
        this.fileName = fileName;
    }

    @Override // com.stepos.agentframework.chatui.s2
    public Object a(Context context, InterfaceC4014c<? super String> interfaceC4014c) throws Throwable {
        InputStream inputStreamOpen;
        InputStream inputStream = null;
        try {
            inputStreamOpen = context.getAssets().open(this.fileName);
        } catch (Throwable th) {
            th = th;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, C0953c.UTF_8), com.stepos.agentframework.chatui.longtext.b.THRESHOLD);
            try {
                String strE = l9.m.e(bufferedReader);
                l9.b.a(bufferedReader, null);
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
                return strE;
            } finally {
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = inputStreamOpen;
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    public /* synthetic */ C2039p1(String str, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? ToolNameMapping.ASSET_FILE : str);
    }
}
