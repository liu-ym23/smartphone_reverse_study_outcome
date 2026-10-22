package com.stepos.ailauncher.agent.skill.installer;

import Ua.M;
import Y8.t;
import com.stepos.ailauncher.agent.skill.SkillItem;
import e9.InterfaceC4014c;
import eb.InterfaceC4021a;
import f9.C4063a;
import g9.InterfaceC4112d;
import g9.h;
import h8.C4148a;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Ljava/io/File;", "<anonymous>", "(LUa/M;)Ljava/io/File;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.installer.SkillZipCache$resolveLocalZip$2", f = "SkillZipCache.kt", l = {122}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SkillZipCache$resolveLocalZip$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super File>, Object> {
    final /* synthetic */ SkillItem $item;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkillZipCache$resolveLocalZip$2(SkillItem skillItem, InterfaceC4014c<? super SkillZipCache$resolveLocalZip$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$item = skillItem;
    }

    public static final InterfaceC4021a i(String str) {
        return eb.f.b(false, 1, null);
    }

    public static final InterfaceC4021a n(InterfaceC5074l interfaceC5074l, Object obj) {
        return (InterfaceC4021a) interfaceC5074l.invoke(obj);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SkillZipCache$resolveLocalZip$2(this.$item, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super File> interfaceC4014c) {
        return ((SkillZipCache$resolveLocalZip$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String versionName;
        File fileF;
        String str;
        InterfaceC4021a interfaceC4021a;
        SkillItem skillItem;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            String localZipAbsolutePath = this.$item.getLocalZipAbsolutePath();
            File file = localZipAbsolutePath != null ? new File(localZipAbsolutePath) : null;
            if (file != null && file.exists()) {
                return file;
            }
            versionName = this.$item.getVersionName();
            if (versionName == null) {
                throw new IllegalArgumentException("resolveLocalZip: missing versionName for slug=" + this.$item.getSlug());
            }
            SkillZipCache skillZipCache = SkillZipCache.INSTANCE;
            fileF = skillZipCache.f(this.$item.getName(), versionName);
            if (fileF.exists()) {
                C4148a.d("SkillZipCache", "cache hit slug=" + this.$item.getSlug() + " version=" + versionName + " -> " + fileF.getAbsolutePath(), false, 4, null);
                return fileF;
            }
            String remoteZipUrl = this.$item.getRemoteZipUrl();
            if (remoteZipUrl == null) {
                throw new IllegalArgumentException("resolveLocalZip: missing remoteZipUrl for slug=" + this.$item.getSlug());
            }
            String strG = skillZipCache.g(this.$item.getName(), versionName);
            ConcurrentHashMap concurrentHashMap = SkillZipCache.locks;
            final InterfaceC5074l interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.skill.installer.f
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return SkillZipCache$resolveLocalZip$2.i((String) obj2);
                }
            };
            Object objComputeIfAbsent = concurrentHashMap.computeIfAbsent(strG, new Function() { // from class: com.stepos.ailauncher.agent.skill.installer.g
                @Override // java.util.function.Function
                public final Object apply(Object obj2) {
                    return SkillZipCache$resolveLocalZip$2.n(interfaceC5074l, obj2);
                }
            });
            kotlin.jvm.internal.p.h(objComputeIfAbsent, "computeIfAbsent(...)");
            InterfaceC4021a interfaceC4021a2 = (InterfaceC4021a) objComputeIfAbsent;
            SkillItem skillItem2 = this.$item;
            this.L$0 = h.a(file);
            this.L$1 = versionName;
            this.L$2 = fileF;
            this.L$3 = remoteZipUrl;
            this.L$4 = h.a(strG);
            this.L$5 = h.a(interfaceC4021a2);
            this.L$6 = interfaceC4021a2;
            this.L$7 = skillItem2;
            this.I$0 = 0;
            this.label = 1;
            if (interfaceC4021a2.m(null, this) == objG) {
                return objG;
            }
            str = remoteZipUrl;
            interfaceC4021a = interfaceC4021a2;
            skillItem = skillItem2;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            skillItem = (SkillItem) this.L$7;
            interfaceC4021a = (InterfaceC4021a) this.L$6;
            str = (String) this.L$3;
            fileF = (File) this.L$2;
            versionName = (String) this.L$1;
            C4849c.b(obj);
        }
        try {
            if (fileF.exists()) {
                C4148a.d("SkillZipCache", "cache hit after lock slug=" + skillItem.getSlug() + " version=" + versionName, false, 4, null);
            } else {
                SkillZipCache.INSTANCE.h(str, fileF);
            }
            interfaceC4021a.l(null);
            return fileF;
        } catch (Throwable th) {
            interfaceC4021a.l(null);
            throw th;
        }
    }
}
