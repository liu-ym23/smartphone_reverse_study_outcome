package com.alibaba.fastjson.serializer;

import java.util.Arrays;

/* JADX INFO: loaded from: classes28.dex */
public class Labels {

    public static class DefaultLabelFilter implements LabelFilter {
        private String[] excludes;
        private String[] includes;

        @Override // com.alibaba.fastjson.serializer.LabelFilter
        public boolean apply(String r100) {
            String[] r101 = this.excludes;
            if (r101 != null) goto L5;
            String[] r102 = this.includes;
            if (r102 != null) goto L12;
        L14:
            return false;
        L12:
            if (Arrays.binarySearch(r102, r100) < 0) goto L14;
            return true;
        L5:
            if (Arrays.binarySearch(r101, r100) < 0) goto L16;
            return false;
        L16:
            return true;
        }

        public DefaultLabelFilter(String[] r100, String[] r101) {
            if (r100 == null) goto L5;
            String[] r102 = new String[r100.length];
            this.includes = r102;
            System.arraycopy(r100, 0, r102, 0, r100.length);
            Arrays.sort(this.includes);
        L5:
            if (r101 == null) goto L8;
            String[] r103 = new String[r101.length];
            this.excludes = r103;
            System.arraycopy(r101, 0, r103, 0, r101.length);
            Arrays.sort(this.excludes);
            return;
        }
    }

    public Labels() {
    }

    public static LabelFilter excludes(String... r100) {
        return new DefaultLabelFilter(null, r100);
    }

    public static LabelFilter includes(String... r100) {
        return new DefaultLabelFilter(r100, null);
    }
}
