package com.obric.oui.constraintlayout.core.dsl;

import com.android.contacts.common.SimContactsConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Chain extends Helper {
    protected static final Map<Style, String> styleMap = null;
    private Style mStyle;
    protected ArrayList<Ref> references;

    public class Anchor {
        Constraint.Anchor mConnection;
        int mGoneMargin;
        int mMargin;
        final Constraint.Side mSide;
        final /* synthetic */ Chain this$0;

        Anchor(Chain r1, Constraint.Side r2) {
            this.this$0 = r1;
            this.mConnection = null;
            this.mGoneMargin = Integer.MIN_VALUE;
            this.mSide = r2;
        }

        public String getId() {
            return this.this$0.name;
        }

        public void build(StringBuilder r2) {
            if (this.mConnection == null) goto L6;
            r2.append(this.mSide.toString().toLowerCase()).append(SimContactsConstants.ANR_SEP).append(this).append(",\n");
            return;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("[");
            if (this.mConnection == null) goto L6;
            r0.append("'").append(this.mConnection.getId()).append("','").append(this.mConnection.mSide.toString().toLowerCase()).append("'");
        L6:
            if (this.mMargin == 0) goto L9;
            r0.append(SimContactsConstants.EMAIL_SEP).append(this.mMargin);
        L9:
            if (this.mGoneMargin != Integer.MIN_VALUE) goto L11;
        L14:
            r0.append("]");
            return r0.toString();
        L11:
            if (this.mMargin != 0) goto L13;
            r0.append(",0,").append(this.mGoneMargin);
            goto L14
        L13:
            r0.append(SimContactsConstants.EMAIL_SEP).append(this.mGoneMargin);
            goto L14
        }
    }

    public static final enum Style extends Enum<Style> {
        private static final /* synthetic */ Style[] $VALUES = null;
        public static final Style PACKED = null;
        public static final Style SPREAD = null;
        public static final Style SPREAD_INSIDE = null;

        private Style(String r1, int r2) {
            super(r1, r2);
        }

        public static Style valueOf(String r1) {
            return (Style) Enum.valueOf(Style.class, r1);
        }

        public static Style[] values() {
            return (Style[]) $VALUES.clone();
        }

        static {
            Style r0 = new Style("PACKED", 0);
            PACKED = r0;
            Style r1 = new Style("SPREAD", 1);
            SPREAD = r1;
            Style r3 = new Style("SPREAD_INSIDE", 2);
            SPREAD_INSIDE = r3;
            $VALUES = new Style[]{r0, r1, r3};
        }
    }

    static {
        HashMap r0 = new HashMap();
        styleMap = r0;
        r0.put(Style.SPREAD, "'spread'");
        r0.put(Style.SPREAD_INSIDE, "'spread_inside'");
        r0.put(Style.PACKED, "'packed'");
    }

    public Chain(String r3) {
        super(r3, new Helper.HelperType(""));
        this.mStyle = null;
        this.references = new ArrayList();
    }

    public Style getStyle() {
        return this.mStyle;
    }

    public void setStyle(Style r2) {
        this.mStyle = r2;
        this.configMap.put("style", styleMap.get(r2));
    }

    public String referencesToString() {
        if (this.references.isEmpty() == false) goto L6;
        return "";
    L6:
        StringBuilder r0 = new StringBuilder("[");
        Iterator<Ref> r2 = this.references.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r0.append(r2.next().toString());
        goto L8
    L10:
        r0.append("]");
        return r0.toString();
    }

    public Chain addReference(Ref r3) {
        this.references.add(r3);
        this.configMap.put("contains", referencesToString());
        return this;
    }

    public Chain addReference(String r1) {
        return addReference(Ref.parseStringToRef(r1));
    }
}
