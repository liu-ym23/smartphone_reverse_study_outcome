package com.smt.obric.appstore.assistant.intent;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f17882a;

    public static final class a extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f17883b;

        public /* synthetic */ a(boolean r10, int r11, DefaultConstructorMarker r12) {
            if ((r11 & 1) == 0) goto L5;
            r10 = false;
        L5:
            this(r10);
        }

        @Override // com.smt.obric.appstore.assistant.intent.b
        public boolean a() {
            return this.f17883b;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f17883b == ((a) r10).f17883b) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f17883b);
        }

        public String toString() {
            return "AwaitUserConfirmCellularDataWarning(sessionEnd=" + this.f17883b + ')';
        }

        public a(boolean r10) {
            super(r10, null);
            this.f17883b = r10;
        }
    }

    /* JADX INFO: renamed from: com.smt.obric.appstore.assistant.intent.b$b, reason: collision with other inner class name */
    public static final class C0214b extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f17884b;

        public /* synthetic */ C0214b(boolean r10, int r11, DefaultConstructorMarker r12) {
            if ((r11 & 1) == 0) goto L5;
            r10 = true;
        L5:
            this(r10);
        }

        @Override // com.smt.obric.appstore.assistant.intent.b
        public boolean a() {
            return this.f17884b;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof C0214b) == true) goto L9;
            return false;
        L9:
            if (this.f17884b == ((C0214b) r10).f17884b) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f17884b);
        }

        public String toString() {
            return "Downloaded(sessionEnd=" + this.f17884b + ')';
        }

        public C0214b(boolean r10) {
            super(r10, null);
            this.f17884b = r10;
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f17885b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f17886c;

        public /* synthetic */ c(boolean r10, boolean r11, int r12, DefaultConstructorMarker r13) {
            if ((r12 & 2) == 0) goto L5;
            r11 = true;
        L5:
            this(r10, r11);
        }

        @Override // com.smt.obric.appstore.assistant.intent.b
        public boolean a() {
            return this.f17886c;
        }

        public final boolean b() {
            return this.f17885b;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L8;
            return false;
        L8:
            c r11 = (c) r10;
            if (this.f17885b == r11.f17885b) goto L12;
            return false;
        L12:
            if (this.f17886c == r11.f17886c) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.f17885b) * 31) + Boolean.hashCode(this.f17886c);
        }

        public String toString() {
            return "EnqueuedWiFiDownload(byUser=" + this.f17885b + ", sessionEnd=" + this.f17886c + ')';
        }

        public c(boolean r10, boolean r11) {
            super(r11, null);
            this.f17885b = r10;
            this.f17886c = r11;
        }
    }

    public static final class d extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f17887b;

        public /* synthetic */ d(boolean r10, int r11, DefaultConstructorMarker r12) {
            if ((r11 & 1) == 0) goto L5;
            r10 = true;
        L5:
            this(r10);
        }

        @Override // com.smt.obric.appstore.assistant.intent.b
        public boolean a() {
            return this.f17887b;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof d) == true) goto L9;
            return false;
        L9:
            if (this.f17887b == ((d) r10).f17887b) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f17887b);
        }

        public String toString() {
            return "Error(sessionEnd=" + this.f17887b + ')';
        }

        public d(boolean r10) {
            super(r10, null);
            this.f17887b = r10;
        }
    }

    public static final class e extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f17888b;

        public /* synthetic */ e(boolean r10, int r11, DefaultConstructorMarker r12) {
            if ((r11 & 1) == 0) goto L5;
            r10 = true;
        L5:
            this(r10);
        }

        @Override // com.smt.obric.appstore.assistant.intent.b
        public boolean a() {
            return this.f17888b;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof e) == true) goto L9;
            return false;
        L9:
            if (this.f17888b == ((e) r10).f17888b) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f17888b);
        }

        public String toString() {
            return "Searched(sessionEnd=" + this.f17888b + ')';
        }

        public e(boolean r10) {
            super(r10, null);
            this.f17888b = r10;
        }
    }

    public /* synthetic */ b(boolean r10, DefaultConstructorMarker r11) {
        this(r10);
    }

    public abstract boolean a();

    public b(boolean r10) {
        this.f17882a = r10;
    }
}
