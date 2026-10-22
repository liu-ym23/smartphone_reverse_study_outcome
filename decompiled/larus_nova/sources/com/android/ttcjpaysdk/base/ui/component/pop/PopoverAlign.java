package com.android.ttcjpaysdk.base.ui.component.pop;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/pop/PopoverAlign;", "", "(Ljava/lang/String;I)V", "MIDDLE", GXAnimation.STATE_START, GXAnimation.STATE_END, "ABSOLUT", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum PopoverAlign extends Enum<PopoverAlign> {
    private static final /* synthetic */ PopoverAlign[] $VALUES = null;
    public static final PopoverAlign ABSOLUT = null;
    public static final PopoverAlign END = null;
    public static final PopoverAlign MIDDLE = null;
    public static final PopoverAlign START = null;

    private static final /* synthetic */ PopoverAlign[] $values() {
        return new PopoverAlign[]{MIDDLE, START, END, ABSOLUT};
    }

    public static PopoverAlign valueOf(String r100) {
        return (PopoverAlign) a.a(PopoverAlign.class, r100);
    }

    public static PopoverAlign[] values() {
        return (PopoverAlign[]) $VALUES.clone();
    }

    static {
        MIDDLE = new PopoverAlign("MIDDLE", 0);
        START = new PopoverAlign(GXAnimation.STATE_START, 1);
        END = new PopoverAlign(GXAnimation.STATE_END, 2);
        ABSOLUT = new PopoverAlign("ABSOLUT", 3);
        $VALUES = $values();
    }

    private PopoverAlign(String r100, int r101) {
        super(r100, r101);
    }
}
