package com.android.ttcjpaysdk.base.service.annotation.bean;

import com.ss.android.lark.banner.export.entity.BannerBizName;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
public class CJRouterBean {
    public Class targetClz;
    public Type type;

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type ACTIVITY = null;
        public static final Type FRAGMENT = null;

        static {
            Type r100 = new Type(BannerBizName.ACTIVITY, 0);
            ACTIVITY = r100;
            Type r101 = new Type("FRAGMENT", 1);
            FRAGMENT = r101;
            $VALUES = new Type[]{r100, r101};
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public CJRouterBean() {
    }

    private CJRouterBean(Type r100, Class<?> r101) {
        this.type = r100;
        this.targetClz = r101;
    }

    public static CJRouterBean create(Type r100, Class<?> r101) {
        return new CJRouterBean(r100, r101);
    }
}
