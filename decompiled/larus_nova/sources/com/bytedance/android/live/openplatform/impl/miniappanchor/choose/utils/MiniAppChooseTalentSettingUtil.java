package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.utils;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.config.h90;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.ies.utility.SharedPrefHelper;
import jc1.k;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
public final class MiniAppChooseTalentSettingUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SharedPrefHelper f84297a = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/utils/MiniAppChooseTalentSettingUtil$Type;", "", "", "value", "I", "getValue", "()I", "MINIAPP", "TALENT", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Type extends Enum<Type> {
        public static final Type MINIAPP = null;
        public static final Type TALENT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f84298a = null;
        private final int value;

        static {
            Type r100 = new Type("MINIAPP", 0, 0);
            MINIAPP = r100;
            Type r101 = new Type("TALENT", 1, 1);
            TALENT = r101;
            f84298a = new Type[]{r100, r101};
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        public static Type[] values() {
            return (Type[]) f84298a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        f84297a = SharedPrefHelper.b(s1.getContext());
    }

    public static int a() {
        StringBuilder r100 = new StringBuilder("miniapp_mount_module_uid_key:");
        IUserService r101 = (IUserService) k.f(IUserService.class);
        if (r101 == null) goto L7;
        f r102 = r101.user();
        if (r102 == null) goto L7;
        String r103 = r102.n();
    L8:
        r100.append(r103);
        String r104 = r100.toString();
        return f84297a.h(r104, Type.MINIAPP.getValue());
    L7:
        r103 = null;
        goto L8
    }

    public static boolean b() {
        return h90.f120354a.getValue().booleanValue();
    }
}
