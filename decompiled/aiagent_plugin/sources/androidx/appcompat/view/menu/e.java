package androidx.appcompat.view.menu;

/* JADX INFO: compiled from: MenuView.java */
/* JADX INFO: loaded from: classes.dex */
public interface e {

    /* JADX INFO: compiled from: MenuView.java */
    public interface a {
        MenuItemImpl getItemData();

        void initialize(MenuItemImpl r1, int r2);

        boolean prefersCondensedTitle();
    }

    void initialize(MenuBuilder r1);
}
