package io.noties.markwon.html.jsoup.parser;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class ParseErrorList extends ArrayList<b> {

    /* renamed from: a, reason: collision with root package name */
    public final int f34219a;

    public ParseErrorList(int i10, int i11) {
        super(i10);
        this.f34219a = i11;
    }

    public static ParseErrorList i() {
        return new ParseErrorList(0, 0);
    }

    public boolean f() {
        return size() < this.f34219a;
    }
}
