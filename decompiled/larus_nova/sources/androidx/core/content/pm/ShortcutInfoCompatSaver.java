package androidx.core.content.pm;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ShortcutInfoCompatSaver<T> {

    public static class NoopImpl extends ShortcutInfoCompatSaver<Void> {
        @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
        /* JADX INFO: renamed from: addShortcuts, reason: avoid collision after fix types in other method */
        public Void addShortcuts2(List<ShortcutInfoCompat> r100) {
            return null;
        }

        @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
        /* JADX INFO: renamed from: removeAllShortcuts, reason: avoid collision after fix types in other method */
        public Void removeAllShortcuts2() {
            return null;
        }

        @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
        /* JADX INFO: renamed from: removeShortcuts, reason: avoid collision after fix types in other method */
        public Void removeShortcuts2(List<String> r100) {
            return null;
        }

        @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
        public /* bridge */ /* synthetic */ Void removeAllShortcuts() {
            return removeAllShortcuts2();
        }

        public NoopImpl() {
        }

        @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
        public /* bridge */ /* synthetic */ Void addShortcuts(List r100) {
            return addShortcuts2(r100);
        }

        @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
        public /* bridge */ /* synthetic */ Void removeShortcuts(List r100) {
            return removeShortcuts2(r100);
        }
    }

    public ShortcutInfoCompatSaver() {
    }

    public abstract T addShortcuts(List<ShortcutInfoCompat> r100);

    public abstract T removeAllShortcuts();

    public abstract T removeShortcuts(List<String> r100);

    public List<ShortcutInfoCompat> getShortcuts() throws Exception {
        return new ArrayList();
    }
}
