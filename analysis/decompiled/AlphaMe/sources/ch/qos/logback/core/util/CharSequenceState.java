package ch.qos.logback.core.util;

/* loaded from: classes.dex */
class CharSequenceState {

    /* renamed from: c, reason: collision with root package name */
    final char f4518c;
    int occurrences = 1;

    public CharSequenceState(char c4) {
        this.f4518c = c4;
    }

    public void incrementOccurrences() {
        this.occurrences++;
    }
}
