package com.bytedance.android.livesdk.message.interceptor;

import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.livesdk.message.model.em;
import com.bytedance.android.livesdk.message.model.ik;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.message.CommonMessageData;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes11.dex */
public final class CommonFilterInterceptor implements vlc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f153524a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<a> f153525b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CommonFilterInterceptor f153526c = null;

    public interface a {
        String get(String r100);
    }

    public static final class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f153527a = null;

        public b() {
        }

        static {
            f153527a = new b();
        }

        @Override // com.bytedance.android.livesdk.message.interceptor.CommonFilterInterceptor.a
        public final String get(String r100) {
            Intrinsics.checkNotNullParameter(r100, "key");
            return (String) SettingUtil.getValue("key_ttlive_sdk_setting", r100, String.class, "");
        }
    }

    public CommonFilterInterceptor() {
    }

    static {
        f153526c = new CommonFilterInterceptor();
        LinkedHashMap r100 = new LinkedHashMap();
        f153524a = r100;
        f153525b = CollectionsKt.listOf(new a[]{new com.bytedance.android.livesdk.message.interceptor.b(r100), b.f153527a});
    }

    @Override // vlc.b
    public final boolean onMessage(tlc.d r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if ((r100 instanceof ik) == false) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L12;
        return false;
    L12:
        if ((r100 instanceof BaseMessage) == true) goto L14;
        r100 = null;
    L14:
        BaseMessage r102 = (BaseMessage) r100;
        if (r102 == null) goto L39;
        CommonMessageData r103 = r102.baseMessage;
        if (r103 == null) goto L39;
        final String r104 = r103.msgProcessFilterK;
        String r105 = "";
        if (r104 != null) goto L22;
        r104 = "";
    L22:
        String r106 = r103.msgProcessFilterV;
        if (r106 == null) goto L27;
        r105 = r106;
    L27:
        if (r104.length() != 0) goto L29;
        boolean r107 = true;
    L30:
        if (r107 == true) goto L39;
        if (r105.length() != 0) goto L34;
        boolean r108 = true;
    L35:
        if (r108 == true) goto L39;
        return !Intrinsics.areEqual(r105, (String) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(f153525b), new CommonFilterInterceptor$onMessage$ruleV$1(r104))));
    L34:
        r108 = false;
        goto L35
    L29:
        r107 = false;
    L39:
        return false;
    L5:
        if ((r100 instanceof em) == true) goto L8;
        r101 = false;
        goto L9
    }
}
