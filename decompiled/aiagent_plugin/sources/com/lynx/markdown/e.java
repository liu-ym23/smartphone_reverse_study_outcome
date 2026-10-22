package com.lynx.markdown;

/* JADX INFO: compiled from: MarkdownInlineViewRunDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f13882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f13883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f13884c;

    public e(int r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.f13882a = r4;
        this.f13884c = r3;
    }

    @Override // com.lynx.markdown.i, com.lynx.markdown.a.c
    public float a() {
        return -(this.f13884c + this.f13883b);
    }

    @Override // com.lynx.markdown.i, com.lynx.markdown.a.c
    public float c() {
        return this.f13906e - (this.f13884c + this.f13883b);
    }
}
