package com.android.common.content;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ProjectionMap extends HashMap<String, String> {
    private String[] mColumns;

    public static class Builder {
        private ProjectionMap mMap;

        public Builder() {
            this.mMap = new ProjectionMap();
        }

        public Builder add(String r2) {
            ProjectionMap.access$000(this.mMap, r2, r2);
            return this;
        }

        public Builder add(String r3, String r4) {
            ProjectionMap.access$000(this.mMap, r3, r4 + " AS " + r3);
            return this;
        }

        public Builder addAll(String[] r4) {
            int r0 = r4.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            add(r4[r1]);
            r1 = r1 + 1;
            goto L3
        L5:
            return this;
        }

        public Builder addAll(ProjectionMap r4) {
            Iterator<Map.Entry<String, String>> r5 = r4.entrySet().iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            Map.Entry<String, String> r0 = r5.next();
            ProjectionMap.access$000(this.mMap, r0.getKey(), r0.getValue());
            goto L4
        L6:
            return this;
        }

        public ProjectionMap build() {
            String[] r0 = new String[this.mMap.size()];
            this.mMap.keySet().toArray(r0);
            Arrays.sort(r0);
            ProjectionMap.access$102(this.mMap, r0);
            return this.mMap;
        }
    }

    public ProjectionMap() {
    }

    static /* synthetic */ void access$000(ProjectionMap r0, String r1, String r2) {
        r0.putColumn(r1, r2);
    }

    static /* synthetic */ String[] access$102(ProjectionMap r0, String[] r1) {
        r0.mColumns = r1;
        return r1;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object r1, Object r2) {
        return put((String) r1, (String) r2);
    }

    public static Builder builder() {
        return new Builder();
    }

    public String[] getColumnNames() {
        return this.mColumns;
    }

    private void putColumn(String r1, String r2) {
        super.put(r1, r2);
    }

    public String put(String r1, String r2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends String, ? extends String> r1) {
        throw new UnsupportedOperationException();
    }
}
