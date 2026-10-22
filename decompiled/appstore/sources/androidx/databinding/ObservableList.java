package androidx.databinding;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ObservableList<T> extends List<T> {

    public static abstract class a {
        public a() {
        }

        public abstract void a(ObservableList r10);

        public abstract void b(ObservableList r10, int r11, int r12);

        public abstract void c(ObservableList r10, int r11, int r12);

        public abstract void d(ObservableList r10, int r11, int r12, int r13);

        public abstract void e(ObservableList r10, int r11, int r12);
    }

    void addOnListChangedCallback(a r10);

    void removeOnListChangedCallback(a r10);
}
