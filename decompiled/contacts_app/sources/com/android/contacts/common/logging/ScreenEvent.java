package com.android.contacts.common.logging;

/* JADX INFO: loaded from: classes.dex */
public final class ScreenEvent {

    public static final class ScreenType {
        public static final int ALL_CONTACTS = 4;
        public static final int EDITOR = 6;
        public static final int FAVORITES = 3;
        public static final int QUICK_CONTACT = 5;
        public static final int SEARCH = 1;
        public static final int SEARCH_EXIT = 2;
        public static final int UNKNOWN = 0;

        public static String getFriendlyName(int r0) {
            switch(r0) {
                case 1: goto L13;
                case 2: goto L13;
                case 3: goto L11;
                case 4: goto L9;
                case 5: goto L7;
                case 6: goto L5;
                default: goto L3;
            };
        L3:
            return null;
        L5:
            return "Editor";
        L7:
            return "QuickContact";
        L9:
            return "AllContacts";
        L11:
            return "Favorites";
        L13:
            return "Search";
        }

        private ScreenType() {
        }
    }

    private ScreenEvent() {
    }
}
