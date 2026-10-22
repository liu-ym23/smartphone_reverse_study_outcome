package androidx.databinding;

/* JADX INFO: loaded from: classes.dex */
public interface Observable {

    public static abstract class a {
        public a() {
        }

        public abstract void a(Observable r10, int r11);
    }

    void addOnPropertyChangedCallback(a r10);

    void removeOnPropertyChangedCallback(a r10);
}
