package org.yaml.snakeyaml.error;

/* loaded from: classes5.dex */
public class MarkedYAMLException extends YAMLException {
    private static final long serialVersionUID = -9119388488683035101L;
    private final String context;
    private final Mark contextMark;
    private final String note;
    private final String problem;
    private final Mark problemMark;

    public MarkedYAMLException(String str, Mark mark, String str2, Mark mark2, String str3) {
        this(str, mark, str2, mark2, str3, null);
    }

    public String getContext() {
        return this.context;
    }

    public Mark getContextMark() {
        return this.contextMark;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return toString();
    }

    public String getProblem() {
        return this.problem;
    }

    public Mark getProblemMark() {
        return this.problemMark;
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        String str = this.context;
        if (str != null) {
            sb2.append(str);
            sb2.append("\n");
        }
        Mark mark = this.contextMark;
        if (mark != null && (this.problem == null || this.problemMark == null || mark.getName().equals(this.problemMark.getName()) || this.contextMark.getLine() != this.problemMark.getLine() || this.contextMark.getColumn() != this.problemMark.getColumn())) {
            sb2.append(this.contextMark);
            sb2.append("\n");
        }
        String str2 = this.problem;
        if (str2 != null) {
            sb2.append(str2);
            sb2.append("\n");
        }
        Mark mark2 = this.problemMark;
        if (mark2 != null) {
            sb2.append(mark2);
            sb2.append("\n");
        }
        String str3 = this.note;
        if (str3 != null) {
            sb2.append(str3);
            sb2.append("\n");
        }
        return sb2.toString();
    }

    public MarkedYAMLException(String str, Mark mark, String str2, Mark mark2, String str3, Throwable th) {
        super(str + "; " + str2 + "; " + mark2, th);
        this.context = str;
        this.contextMark = mark;
        this.problem = str2;
        this.problemMark = mark2;
        this.note = str3;
    }

    public MarkedYAMLException(String str, Mark mark, String str2, Mark mark2) {
        this(str, mark, str2, mark2, null, null);
    }

    public MarkedYAMLException(String str, Mark mark, String str2, Mark mark2, Throwable th) {
        this(str, mark, str2, mark2, null, th);
    }
}
