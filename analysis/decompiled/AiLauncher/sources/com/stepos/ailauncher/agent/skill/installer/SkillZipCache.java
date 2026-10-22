package com.stepos.ailauncher.agent.skill.installer;

import Mb.InterfaceC0967e;
import Mb.InterfaceC0968f;
import Mb.u;
import Mb.v;
import Ua.C1056g;
import Ua.Y;
import Y8.h;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.skill.SkillItem;
import com.stepos.ailauncher.common.utils.C3197a;
import e9.InterfaceC4014c;
import eb.InterfaceC4021a;
import h8.C4148a;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.C4848b;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import tb.AbstractC5531D;
import tb.C5528A;
import tb.C5530C;
import tb.z;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/installer/SkillZipCache;", "", "<init>", "()V", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "item", "Ljava/io/File;", "k", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;Le9/c;)Ljava/lang/Object;", "", "slug", "version", "f", "(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "url", "dest", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;Ljava/io/File;)V", "TAG", "Ljava/lang/String;", "SUBDIR", "", "DOWNLOAD_TIMEOUT_SECONDS", "J", "Ljava/util/concurrent/ConcurrentHashMap;", "Leb/a;", "locks", "Ljava/util/concurrent/ConcurrentHashMap;", "Ltb/z;", "httpClient$delegate", "LY8/h;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Ltb/z;", "httpClient", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SkillZipCache {
    private static final long DOWNLOAD_TIMEOUT_SECONDS = 60;
    private static final String SUBDIR = "skill_zips";
    private static final String TAG = "SkillZipCache";
    public static final SkillZipCache INSTANCE = new SkillZipCache();
    private static final ConcurrentHashMap<String, InterfaceC4021a> locks = new ConcurrentHashMap<>();

    /* renamed from: httpClient$delegate, reason: from kotlin metadata */
    private static final h httpClient = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.skill.installer.e
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return SkillZipCache.j();
        }
    });

    public static final z j() {
        z.a aVar = new z.a();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return aVar.g(DOWNLOAD_TIMEOUT_SECONDS, timeUnit).T(DOWNLOAD_TIMEOUT_SECONDS, timeUnit).W(DOWNLOAD_TIMEOUT_SECONDS, timeUnit).d();
    }

    public final File f(String slug, String version) {
        File file = new File(C3197a.INSTANCE.a().getFilesDir(), SUBDIR);
        file.mkdirs();
        return new File(file, slug + "_" + version + ".zip");
    }

    public final String g(String slug, String version) {
        return slug + "@" + version;
    }

    public final void h(String url, File dest) throws IOException {
        C4148a.d(TAG, "downloading " + url + " -> " + dest.getAbsolutePath(), false, 4, null);
        File file = new File(dest.getParentFile(), dest.getName() + ".part");
        if (file.exists()) {
            file.delete();
        }
        C5530C c5530cExecute = i().a(new C5528A.a().t(url).b()).execute();
        try {
            if (!c5530cExecute.getIsSuccessful()) {
                throw new IOException("download failed http=" + c5530cExecute.getCode() + " url=" + url);
            }
            AbstractC5531D body = c5530cExecute.getBody();
            if (body == null) {
                throw new IOException("download failed: empty body url=" + url);
            }
            InterfaceC0967e interfaceC0967eB = u.b(v.d(file, false, 1, null));
            try {
                InterfaceC0968f source = body.getSource();
                try {
                    interfaceC0967eB.V0(source);
                    l9.b.a(source, null);
                    l9.b.a(interfaceC0967eB, null);
                    l9.b.a(c5530cExecute, null);
                    if (file.renameTo(dest)) {
                        C4148a.d(TAG, "downloaded " + dest.length() + " bytes -> " + dest.getAbsolutePath(), false, 4, null);
                        return;
                    }
                    file.delete();
                    throw new IOException("download failed: rename " + file.getName() + " -> " + dest.getName());
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    public final z i() {
        return (z) httpClient.getValue();
    }

    public final Object k(SkillItem skillItem, InterfaceC4014c<? super File> interfaceC4014c) {
        return C1056g.j(Y.b(), new SkillZipCache$resolveLocalZip$2(skillItem, null), interfaceC4014c);
    }
}
