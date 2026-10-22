package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* JADX INFO: loaded from: classes.dex */
public class ShapeTrimPath implements ContentModel {
    private final AnimatableFloatValue end;
    private final boolean hidden;
    private final String name;
    private final AnimatableFloatValue offset;
    private final AnimatableFloatValue start;
    private final Type type;

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type INDIVIDUALLY = null;
        public static final Type SIMULTANEOUSLY = null;

        private static /* synthetic */ Type[] $values() {
            return new Type[]{SIMULTANEOUSLY, INDIVIDUALLY};
        }

        private Type(String r1, int r2) {
            super(r1, r2);
        }

        public static Type valueOf(String r1) {
            return (Type) Enum.valueOf(Type.class, r1);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        static {
            SIMULTANEOUSLY = new Type("SIMULTANEOUSLY", 0);
            INDIVIDUALLY = new Type("INDIVIDUALLY", 1);
            $VALUES = $values();
        }

        public static Type forId(int r3) {
            if (r3 == 1) goto L11;
            if (r3 != 2) goto L9;
            return INDIVIDUALLY;
        L9:
            throw new IllegalArgumentException("Unknown trim path type " + r3);
        L11:
            return SIMULTANEOUSLY;
        }
    }

    public ShapeTrimPath(String r1, Type r2, AnimatableFloatValue r3, AnimatableFloatValue r4, AnimatableFloatValue r5, boolean r6) {
        this.name = r1;
        this.type = r2;
        this.start = r3;
        this.end = r4;
        this.offset = r5;
        this.hidden = r6;
    }

    public String getName() {
        return this.name;
    }

    public Type getType() {
        return this.type;
    }

    public AnimatableFloatValue getEnd() {
        return this.end;
    }

    public AnimatableFloatValue getStart() {
        return this.start;
    }

    public AnimatableFloatValue getOffset() {
        return this.offset;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable r1, LottieComposition r2, BaseLayer r3) {
        return new TrimPathContent(r3, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.start + ", end: " + this.end + ", offset: " + this.offset + "}";
    }
}
