package com.stepos.agentframework.chatcore.utils;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.ChatCoreSdk;
import com.stepos.ame.sdk.SkillStoreKt;
import e9.InterfaceC4014c;
import g9.C4109a;
import h8.C4148a;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import u4.m;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\t\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/stepos/agentframework/chatcore/utils/PreProcessor;", "", "<init>", "()V", "Lu4/m$e;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "", Const.INTENT_KEY_PKGNAME, "(Lu4/m$e;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "", "TAG", "Ljava/lang/String;", "CHAT_IMAGE_USER_FILE", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PreProcessor {
    private static final String CHAT_IMAGE_USER_FILE = "chat/image/user/";
    public static final PreProcessor INSTANCE = new PreProcessor();
    private static final String TAG = " [PreProcessor]";

    public final Object a(m.ImageMessage imageMessage, InterfaceC4014c<? super Boolean> interfaceC4014c) throws Exception {
        String str = TAG;
        C4148a.j(str, "imageCompress " + imageMessage, true);
        try {
            String str2 = "image-" + System.currentTimeMillis() + ".jpeg";
            File file = new File(ChatCoreSdk.INSTANCE.c().getExternalCacheDir(), "chat/image/user//" + str2);
            b bVar = b.INSTANCE;
            String path = file.getPath();
            p.h(path, "getPath(...)");
            bVar.b(imageMessage, path);
            imageMessage.s(str2);
            imageMessage.t(file.getPath());
            C4148a.j(str, "imageCompress " + imageMessage + " newFile: " + imageMessage.getLocalPath(), true);
            return C4109a.a(true);
        } catch (Exception e10) {
            throw new Exception(e10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(u4.m.ImageMessage r9, e9.InterfaceC4014c<? super java.lang.Boolean> r10) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.utils.PreProcessor.b(u4.m$e, e9.c):java.lang.Object");
    }
}
