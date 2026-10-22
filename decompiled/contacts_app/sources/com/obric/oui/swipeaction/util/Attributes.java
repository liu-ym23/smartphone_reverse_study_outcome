package com.obric.oui.swipeaction.util;

/* JADX INFO: loaded from: classes4.dex */
public class Attributes {

    public static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode Multiple = null;
        public static final Mode Single = null;

        private Mode(String r1, int r2) {
            super(r1, r2);
        }

        public static Mode valueOf(String r1) {
            return (Mode) Enum.valueOf(Mode.class, r1);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }

        static {
            Mode r0 = new Mode("Single", 0);
            Single = r0;
            Mode r1 = new Mode("Multiple", 1);
            Multiple = r1;
            $VALUES = new Mode[]{r0, r1};
        }
    }

    public Attributes() {
    }
}
