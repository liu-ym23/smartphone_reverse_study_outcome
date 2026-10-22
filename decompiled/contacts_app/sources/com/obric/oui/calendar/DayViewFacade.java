package com.obric.oui.calendar;

import android.graphics.drawable.Drawable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DayViewFacade {
    private Drawable backgroundDrawable;
    private boolean daysDisabled;
    private boolean isDecorated;
    private Drawable selectionDrawable;
    private final LinkedList<Span> spans;

    static class Span {
        final Object span;

        public Span(Object r1) {
            this.span = r1;
        }
    }

    DayViewFacade() {
        this.backgroundDrawable = null;
        this.selectionDrawable = null;
        this.spans = new LinkedList();
        this.daysDisabled = false;
        this.isDecorated = false;
    }

    public void setBackgroundDrawable(Drawable r1) {
        if (r1 == null) goto L6;
        this.backgroundDrawable = r1;
        this.isDecorated = true;
        return;
    L6:
        throw new IllegalArgumentException("Cannot be null");
    }

    public void setSelectionDrawable(Drawable r1) {
        if (r1 == null) goto L6;
        this.selectionDrawable = r1;
        this.isDecorated = true;
        return;
    L6:
        throw new IllegalArgumentException("Cannot be null");
    }

    public void addSpan(Object r3) {
        LinkedList<Span> r0 = this.spans;
        if (r0 == null) goto L6;
        r0.add(new Span(r3));
        this.isDecorated = true;
        return;
    }

    public void setDaysDisabled(boolean r1) {
        this.daysDisabled = r1;
        this.isDecorated = true;
    }

    void reset() {
        this.backgroundDrawable = null;
        this.selectionDrawable = null;
        this.spans.clear();
        this.isDecorated = false;
        this.daysDisabled = false;
    }

    void applyTo(DayViewFacade r3) {
        Drawable r0 = this.selectionDrawable;
        if (r0 == null) goto L5;
        r3.setSelectionDrawable(r0);
    L5:
        Drawable r1 = this.backgroundDrawable;
        if (r1 == null) goto L8;
        r3.setBackgroundDrawable(r1);
    L8:
        r3.spans.addAll(this.spans);
        r3.isDecorated |= this.isDecorated;
        r3.daysDisabled = this.daysDisabled;
    }

    boolean isDecorated() {
        return this.isDecorated;
    }

    Drawable getSelectionDrawable() {
        return this.selectionDrawable;
    }

    Drawable getBackgroundDrawable() {
        return this.backgroundDrawable;
    }

    List<Span> getSpans() {
        return Collections.unmodifiableList(this.spans);
    }

    public boolean areDaysDisabled() {
        return this.daysDisabled;
    }
}
