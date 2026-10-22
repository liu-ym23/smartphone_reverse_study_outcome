package com.google.protobuf;

import androidx.core.internal.view.SupportMenu;
import com.bytedance.librarian.LibrarianImpl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.logging.Logger;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes3.dex */
public final class Descriptors {
    private static final Logger logger = null;

    /* JADX INFO: renamed from: com.google.protobuf.Descriptors$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType = null;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = null;

        static {
            int[] r10 = new int[FieldDescriptor.JavaType.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType = r10;
            r10[FieldDescriptor.JavaType.ENUM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L26
        L64:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[FieldDescriptor.JavaType.MESSAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L27
        L6:
            int[] r11 = new int[FieldDescriptor.Type.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = r11;
            r11[FieldDescriptor.Type.INT32.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L68:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.SINT32.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L84:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.SFIXED32.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L46:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.UINT32.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
        L70:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.FIXED32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L32
        L76:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.INT64.ordinal()] = 6;     // Catch: NoSuchFieldError -> L33
        L52:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.SINT64.ordinal()] = 7;     // Catch: NoSuchFieldError -> L34
        L74:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.SFIXED64.ordinal()] = 8;     // Catch: NoSuchFieldError -> L35
        L80:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.UINT64.ordinal()] = 9;     // Catch: NoSuchFieldError -> L36
        L62:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.FIXED64.ordinal()] = 10;     // Catch: NoSuchFieldError -> L37
        L66:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.FLOAT.ordinal()] = 11;     // Catch: NoSuchFieldError -> L38
        L54:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.DOUBLE.ordinal()] = 12;     // Catch: NoSuchFieldError -> L39
        L56:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.BOOL.ordinal()] = 13;     // Catch: NoSuchFieldError -> L40
        L82:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.STRING.ordinal()] = 14;     // Catch: NoSuchFieldError -> L41
        L50:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.BYTES.ordinal()] = 15;     // Catch: NoSuchFieldError -> L42
        L72:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.ENUM.ordinal()] = 16;     // Catch: NoSuchFieldError -> L43
        L78:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.MESSAGE.ordinal()] = 17;     // Catch: NoSuchFieldError -> L44
        L60:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.GROUP.ordinal()] = 18;     // Catch: NoSuchFieldError -> L45
            return;
        }
    }

    public static final class Descriptor extends GenericDescriptor {
        private final Descriptor containingType;
        private final EnumDescriptor[] enumTypes;
        private final FieldDescriptor[] extensions;
        private final FieldDescriptor[] fields;
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private final Descriptor[] nestedTypes;
        private final OneofDescriptor[] oneofs;
        private DescriptorProtos.DescriptorProto proto;

        public /* synthetic */ Descriptor(DescriptorProtos.DescriptorProto r10, FileDescriptor r11, Descriptor r12, int r13, AnonymousClass1 r14) throws DescriptorValidationException {
            this(r10, r11, r12, r13);
        }

        public static /* synthetic */ void access$1000(Descriptor r10, DescriptorProtos.DescriptorProto r11) {
            r10.setProto(r11);
        }

        public static /* synthetic */ void access$700(Descriptor r10) throws DescriptorValidationException {
            r10.crossLink();
        }

        private void crossLink() throws DescriptorValidationException {
            Descriptor[] r10 = this.nestedTypes;
            int r11 = r10.length;
            int r12 = 0;
            int r13 = 0;
        L3:
            if (r13 >= r11) goto L5;
            r10[r13].crossLink();
            r13 = r13 + 1;
            goto L3
        L5:
            FieldDescriptor[] r14 = this.fields;
            int r15 = r14.length;
            int r16 = 0;
        L6:
            if (r16 >= r15) goto L8;
            FieldDescriptor.access$900(r14[r16]);
            r16 = r16 + 1;
            goto L6
        L8:
            FieldDescriptor[] r17 = this.extensions;
            int r18 = r17.length;
        L9:
            if (r12 >= r18) goto L11;
            FieldDescriptor.access$900(r17[r12]);
            r12 = r12 + 1;
            goto L9
        }

        private void setProto(DescriptorProtos.DescriptorProto r10) {
            this.proto = r10;
            int r11 = 0;
            int r12 = 0;
        L3:
            Descriptor[] r13 = this.nestedTypes;
            if (r12 >= r13.length) goto L6;
            r13[r12].setProto(r10.getNestedType(r12));
            r12 = r12 + 1;
            goto L3
        L6:
            int r14 = 0;
        L7:
            OneofDescriptor[] r15 = this.oneofs;
            if (r14 >= r15.length) goto L10;
            OneofDescriptor.access$2000(r15[r14], r10.getOneofDecl(r14));
            r14 = r14 + 1;
            goto L7
        L10:
            int r16 = 0;
        L11:
            EnumDescriptor[] r17 = this.enumTypes;
            if (r16 >= r17.length) goto L14;
            EnumDescriptor.access$1100(r17[r16], r10.getEnumType(r16));
            r16 = r16 + 1;
            goto L11
        L14:
            int r18 = 0;
        L15:
            FieldDescriptor[] r19 = this.fields;
            if (r18 >= r19.length) goto L18;
            FieldDescriptor.access$1300(r19[r18], r10.getField(r18));
            r18 = r18 + 1;
        L18:
            FieldDescriptor[] r20 = this.extensions;
            if (r11 >= r20.length) goto L21;
            FieldDescriptor.access$1300(r20[r11], r10.getExtension(r11));
            r11 = r11 + 1;
            goto L18
        }

        public EnumDescriptor findEnumTypeByName(String r10) {
            GenericDescriptor r11 = FileDescriptor.access$1400(this.file).findSymbol(this.fullName + '.' + r10);
            if (r11 != null) goto L5;
            return null;
        L5:
            if ((r11 instanceof EnumDescriptor) == true) goto L7;
            return null;
        L7:
            return (EnumDescriptor) r11;
        }

        public FieldDescriptor findFieldByName(String r10) {
            GenericDescriptor r11 = FileDescriptor.access$1400(this.file).findSymbol(this.fullName + '.' + r10);
            if (r11 != null) goto L5;
            return null;
        L5:
            if ((r11 instanceof FieldDescriptor) == true) goto L7;
            return null;
        L7:
            return (FieldDescriptor) r11;
        }

        public FieldDescriptor findFieldByNumber(int r10) {
            return (FieldDescriptor) DescriptorPool.access$1500(FileDescriptor.access$1400(this.file)).get(new DescriptorPool.DescriptorIntPair(this, r10));
        }

        public Descriptor findNestedTypeByName(String r10) {
            GenericDescriptor r11 = FileDescriptor.access$1400(this.file).findSymbol(this.fullName + '.' + r10);
            if (r11 != null) goto L5;
            return null;
        L5:
            if ((r11 instanceof Descriptor) == true) goto L7;
            return null;
        L7:
            return (Descriptor) r11;
        }

        public Descriptor getContainingType() {
            return this.containingType;
        }

        public List<EnumDescriptor> getEnumTypes() {
            return Collections.unmodifiableList(Arrays.asList(this.enumTypes));
        }

        public List<FieldDescriptor> getExtensions() {
            return Collections.unmodifiableList(Arrays.asList(this.extensions));
        }

        public List<FieldDescriptor> getFields() {
            return Collections.unmodifiableList(Arrays.asList(this.fields));
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        public int getIndex() {
            return this.index;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        public List<Descriptor> getNestedTypes() {
            return Collections.unmodifiableList(Arrays.asList(this.nestedTypes));
        }

        public List<OneofDescriptor> getOneofs() {
            return Collections.unmodifiableList(Arrays.asList(this.oneofs));
        }

        public DescriptorProtos.MessageOptions getOptions() {
            return this.proto.getOptions();
        }

        public boolean isExtendable() {
            if (this.proto.getExtensionRangeList().size() == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isExtensionNumber(int r10) {
            Iterator<DescriptorProtos.DescriptorProto.ExtensionRange> r11 = this.proto.getExtensionRangeList().iterator();
        L4:
            if (r11.hasNext() == false) goto L11;
            DescriptorProtos.DescriptorProto.ExtensionRange r12 = r11.next();
            if (r12.getStart() > r10) goto L4;
            if (r10 >= r12.getEnd()) goto L4;
            return true;
        L11:
            return false;
        }

        public boolean isReservedName(String r10) {
            if (r10 == null) goto L13;
            Iterator<String> r11 = this.proto.getReservedNameList().iterator();
        L5:
            if (r11.hasNext() == false) goto L10;
            if (r11.next().equals(r10) == false) goto L5;
            return true;
        L10:
            return false;
        L13:
            throw null;
        }

        public boolean isReservedNumber(int r10) {
            Iterator<DescriptorProtos.DescriptorProto.ReservedRange> r11 = this.proto.getReservedRangeList().iterator();
        L4:
            if (r11.hasNext() == false) goto L11;
            DescriptorProtos.DescriptorProto.ReservedRange r12 = r11.next();
            if (r12.getStart() > r10) goto L4;
            if (r10 >= r12.getEnd()) goto L4;
            return true;
        L11:
            return false;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public /* bridge */ /* synthetic */ Message toProto() {
            return toProto();
        }

        public Descriptor(String r10) throws DescriptorValidationException {
            int r11 = r10.lastIndexOf(46);
            if (r11 == (-1)) goto L5;
            String r12 = r10.substring(r11 + 1);
            String r13 = r10.substring(0, r11);
        L6:
            this.index = 0;
            this.proto = DescriptorProtos.DescriptorProto.newBuilder().setName(r12).addExtensionRange(DescriptorProtos.DescriptorProto.ExtensionRange.newBuilder().setStart(1).setEnd(536870912).build()).build();
            this.fullName = r10;
            this.containingType = null;
            this.nestedTypes = new Descriptor[0];
            this.enumTypes = new EnumDescriptor[0];
            this.fields = new FieldDescriptor[0];
            this.extensions = new FieldDescriptor[0];
            this.oneofs = new OneofDescriptor[0];
            this.file = new FileDescriptor(r13, this);
            return;
        L5:
            r13 = "";
            r12 = r10;
            goto L6
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.DescriptorProto toProto() {
            return this.proto;
        }

        private Descriptor(DescriptorProtos.DescriptorProto r10, FileDescriptor r11, Descriptor r12, int r13) throws DescriptorValidationException {
            this.index = r13;
            this.proto = r10;
            this.fullName = Descriptors.access$1600(r11, r12, r10.getName());
            this.file = r11;
            this.containingType = r12;
            this.oneofs = new OneofDescriptor[r10.getOneofDeclCount()];
            int r14 = 0;
            int r15 = 0;
        L4:
            if (r15 >= r10.getOneofDeclCount()) goto L6;
            this.oneofs[r15] = new OneofDescriptor(r10.getOneofDecl(r15), r11, this, r15, null);
            r15 = r15 + 1;
            goto L4
        L6:
            this.nestedTypes = new Descriptor[r10.getNestedTypeCount()];
            int r16 = 0;
        L8:
            if (r16 >= r10.getNestedTypeCount()) goto L10;
            this.nestedTypes[r16] = new Descriptor(r10.getNestedType(r16), r11, this, r16);
            r16 = r16 + 1;
            goto L8
        L10:
            this.enumTypes = new EnumDescriptor[r10.getEnumTypeCount()];
            int r17 = 0;
        L12:
            if (r17 >= r10.getEnumTypeCount()) goto L14;
            this.enumTypes[r17] = new EnumDescriptor(r10.getEnumType(r17), r11, this, r17, null);
            r17 = r17 + 1;
            goto L12
        L14:
            this.fields = new FieldDescriptor[r10.getFieldCount()];
            int r18 = 0;
        L16:
            if (r18 >= r10.getFieldCount()) goto L18;
            this.fields[r18] = new FieldDescriptor(r10.getField(r18), r11, this, r18, false, null);
            r18 = r18 + 1;
            goto L16
        L18:
            this.extensions = new FieldDescriptor[r10.getExtensionCount()];
            int r19 = 0;
        L20:
            if (r19 >= r10.getExtensionCount()) goto L22;
            this.extensions[r19] = new FieldDescriptor(r10.getExtension(r19), r11, this, r19, true, null);
            r19 = r19 + 1;
            goto L20
        L22:
            int r110 = 0;
        L24:
            if (r110 >= r10.getOneofDeclCount()) goto L27;
            OneofDescriptor r20 = this.oneofs[r110];
            OneofDescriptor.access$1802(r20, new FieldDescriptor[r20.getFieldCount()]);
            OneofDescriptor.access$1902(this.oneofs[r110], 0);
            r110 = r110 + 1;
        L27:
            if (r14 >= r10.getFieldCount()) goto L32;
            OneofDescriptor r111 = this.fields[r14].getContainingOneof();
            if (r111 == null) goto L31;
            OneofDescriptor.access$1800(r111)[OneofDescriptor.access$1908(r111)] = this.fields[r14];
        L31:
            r14 = r14 + 1;
            goto L27
        L32:
            FileDescriptor.access$1400(r11).addSymbol(this);
        }
    }

    public static final class DescriptorPool {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private boolean allowUnknownDependencies;
        private final Set<FileDescriptor> dependencies;
        private final Map<String, GenericDescriptor> descriptorsByName;
        private final Map<DescriptorIntPair, EnumValueDescriptor> enumValuesByNumber;
        private final Map<DescriptorIntPair, FieldDescriptor> fieldsByNumber;

        public static final class DescriptorIntPair {
            private final GenericDescriptor descriptor;
            private final int number;

            public DescriptorIntPair(GenericDescriptor r10, int r11) {
                this.descriptor = r10;
                this.number = r11;
            }

            public boolean equals(Object r10) {
                if ((r10 instanceof DescriptorIntPair) == true) goto L5;
                return false;
            L5:
                DescriptorIntPair r11 = (DescriptorIntPair) r10;
                if (this.descriptor == r11.descriptor) goto L8;
                return false;
            L8:
                if (this.number != r11.number) goto L12;
                return true;
            L12:
                return false;
            }

            public int hashCode() {
                return (this.descriptor.hashCode() * SupportMenu.USER_MASK) + this.number;
            }
        }

        public static final class PackageDescriptor extends GenericDescriptor {
            private final FileDescriptor file;
            private final String fullName;
            private final String name;

            public PackageDescriptor(String r10, String r11, FileDescriptor r12) {
                this.file = r12;
                this.fullName = r11;
                this.name = r10;
            }

            @Override // com.google.protobuf.Descriptors.GenericDescriptor
            public FileDescriptor getFile() {
                return this.file;
            }

            @Override // com.google.protobuf.Descriptors.GenericDescriptor
            public String getFullName() {
                return this.fullName;
            }

            @Override // com.google.protobuf.Descriptors.GenericDescriptor
            public String getName() {
                return this.name;
            }

            @Override // com.google.protobuf.Descriptors.GenericDescriptor
            public Message toProto() {
                return this.file.toProto();
            }
        }

        public static final enum SearchFilter extends java.lang.Enum<SearchFilter> {
            private static final /* synthetic */ SearchFilter[] $VALUES = null;
            public static final SearchFilter AGGREGATES_ONLY = null;
            public static final SearchFilter ALL_SYMBOLS = null;
            public static final SearchFilter TYPES_ONLY = null;

            static {
                SearchFilter r10 = new SearchFilter("TYPES_ONLY", 0);
                TYPES_ONLY = r10;
                SearchFilter r11 = new SearchFilter("AGGREGATES_ONLY", 1);
                AGGREGATES_ONLY = r11;
                SearchFilter r12 = new SearchFilter("ALL_SYMBOLS", 2);
                ALL_SYMBOLS = r12;
                $VALUES = new SearchFilter[]{r10, r11, r12};
            }

            private SearchFilter(String r10, int r11) {
                super(r10, r11);
            }

            public static SearchFilter valueOf(String r10) {
                return (SearchFilter) java.lang.Enum.valueOf(SearchFilter.class, r10);
            }

            public static SearchFilter[] values() {
                return (SearchFilter[]) $VALUES.clone();
            }
        }

        static {
        }

        public DescriptorPool(FileDescriptor[] r10, boolean r11) {
            this.descriptorsByName = new HashMap();
            this.fieldsByNumber = new HashMap();
            this.enumValuesByNumber = new HashMap();
            this.dependencies = new HashSet();
            this.allowUnknownDependencies = r11;
            int r12 = 0;
        L4:
            if (r12 >= r10.length) goto L6;
            this.dependencies.add(r10[r12]);
            importPublicDependencies(r10[r12]);
            r12 = r12 + 1;
            goto L4
        L6:
            Iterator<FileDescriptor> r13 = this.dependencies.iterator();
        L8:
            if (r13.hasNext() == false) goto L12;
            FileDescriptor r14 = r13.next();
            addPackage(r14.getPackage(), r14);     // Catch: DescriptorValidationException -> L13
            goto L8
        }

        public static /* synthetic */ Map access$1500(DescriptorPool r10) {
            return r10.fieldsByNumber;
        }

        public static /* synthetic */ Map access$2400(DescriptorPool r10) {
            return r10.enumValuesByNumber;
        }

        private void importPublicDependencies(FileDescriptor r10) {
            Iterator<FileDescriptor> r11 = r10.getPublicDependencies().iterator();
        L4:
            if (r11.hasNext() == false) goto L8;
            FileDescriptor r12 = r11.next();
            if (this.dependencies.add(r12) == false) goto L4;
            importPublicDependencies(r12);
            goto L4
        }

        public static void validateSymbolName(GenericDescriptor r10) throws DescriptorValidationException {
            String r11 = r10.getName();
            AnonymousClass1 r12 = null;
            if (r11.length() == 0) goto L25;
            boolean r13 = true;
            int r14 = 0;
        L6:
            if (r14 >= r11.length()) goto L20;
            char r15 = r11.charAt(r14);
            if (r15 < 128) goto L11;
            r13 = false;
        L11:
            if (Character.isLetter(r15) == true) goto L19;
            if (r15 == '_') goto L19;
            if (Character.isDigit(r15) == false) goto L18;
            if (r14 > 0) goto L19;
        L18:
            r13 = false;
        L19:
            r14 = r14 + 1;
            goto L6
        L20:
            if (r13 == false) goto L23;
            return;
        L23:
            throw new DescriptorValidationException(r10, TokenParser.DQUOTE + r11 + "\" is not a valid identifier.", r12);
        L25:
            throw new DescriptorValidationException(r10, "Missing name.", r12);
        }

        public void addEnumValueByNumber(EnumValueDescriptor r10) {
            DescriptorIntPair r11 = new DescriptorIntPair(r10.getType(), r10.getNumber());
            EnumValueDescriptor r12 = this.enumValuesByNumber.put(r11, r10);
            if (r12 == null) goto L6;
            this.enumValuesByNumber.put(r11, r12);
            return;
        }

        public void addFieldByNumber(FieldDescriptor r10) throws DescriptorValidationException {
            DescriptorIntPair r11 = new DescriptorIntPair(r10.getContainingType(), r10.getNumber());
            FieldDescriptor r12 = this.fieldsByNumber.put(r11, r10);
            if (r12 != null) goto L5;
            return;
        L5:
            this.fieldsByNumber.put(r11, r12);
            throw new DescriptorValidationException(r10, "Field number " + r10.getNumber() + " has already been used in \"" + r10.getContainingType().getFullName() + "\" by field \"" + r12.getName() + "\".", null);
        }

        public void addPackage(String r10, FileDescriptor r11) throws DescriptorValidationException {
            int r12 = r10.lastIndexOf(46);
            if (r12 != (-1)) goto L5;
            String r13 = r10;
        L6:
            GenericDescriptor r14 = this.descriptorsByName.put(r10, new PackageDescriptor(r13, r10, r11));
            if (r14 == null) goto L13;
            this.descriptorsByName.put(r10, r14);
            if ((r14 instanceof PackageDescriptor) == false) goto L12;
            return;
        L12:
            throw new DescriptorValidationException(r11, TokenParser.DQUOTE + r13 + "\" is already defined (as something other than a package) in file \"" + r14.getFile().getName() + "\".", null);
        L13:
            return;
        L5:
            addPackage(r10.substring(0, r12), r11);
            r13 = r10.substring(r12 + 1);
            goto L6
        }

        public void addSymbol(GenericDescriptor r10) throws DescriptorValidationException {
            validateSymbolName(r10);
            String r11 = r10.getFullName();
            int r12 = r11.lastIndexOf(46);
            GenericDescriptor r13 = this.descriptorsByName.put(r11, r10);
            if (r13 == null) goto L14;
            this.descriptorsByName.put(r11, r13);
            AnonymousClass1 r14 = null;
            if (r10.getFile() != r13.getFile()) goto L13;
            if (r12 != (-1)) goto L11;
            throw new DescriptorValidationException(r10, TokenParser.DQUOTE + r11 + "\" is already defined.", r14);
        L11:
            throw new DescriptorValidationException(r10, TokenParser.DQUOTE + r11.substring(r12 + 1) + "\" is already defined in \"" + r11.substring(0, r12) + "\".", r14);
        L13:
            throw new DescriptorValidationException(r10, TokenParser.DQUOTE + r11 + "\" is already defined in file \"" + r13.getFile().getName() + "\".", r14);
        }

        public GenericDescriptor findSymbol(String r10) {
            return findSymbol(r10, SearchFilter.ALL_SYMBOLS);
        }

        public boolean isAggregate(GenericDescriptor r10) {
            if ((r10 instanceof Descriptor) == false) goto L5;
        L12:
            return true;
        L5:
            if ((r10 instanceof EnumDescriptor) == true) goto L12;
            if ((r10 instanceof PackageDescriptor) == true) goto L12;
            if ((r10 instanceof ServiceDescriptor) == true) goto L12;
            return false;
        }

        public boolean isType(GenericDescriptor r10) {
            if ((r10 instanceof Descriptor) == false) goto L5;
        L8:
            return true;
        L5:
            if ((r10 instanceof EnumDescriptor) == true) goto L8;
            return false;
        }

        public GenericDescriptor lookupSymbol(String r10, GenericDescriptor r11, SearchFilter r12) throws DescriptorValidationException {
            if (r10.startsWith(LibrarianImpl.Constants.DOT) == false) goto L5;
            String r13 = r10.substring(1);
            GenericDescriptor r14 = findSymbol(r13, r12);
        L19:
            if (r14 == null) goto L21;
            return r14;
        L21:
            if (this.allowUnknownDependencies == false) goto L27;
            if (r12 != SearchFilter.TYPES_ONLY) goto L27;
            Descriptors.access$100().warning("The descriptor for message type \"" + r10 + "\" can not be found and a placeholder is created for it");
            Descriptor r15 = new Descriptor(r13);
            this.dependencies.add(r15.getFile());
            return r15;
        L27:
            throw new DescriptorValidationException(r11, TokenParser.DQUOTE + r10 + "\" is not defined.", null);
        L5:
            int r16 = r10.indexOf(46);
            if (r16 != (-1)) goto L8;
            String r17 = r10;
        L9:
            StringBuilder r18 = new StringBuilder(r11.getFullName());
        L10:
            int r19 = r18.lastIndexOf(LibrarianImpl.Constants.DOT);
            if (r19 == (-1)) goto L12;
            int r20 = r19 + 1;
            r18.setLength(r20);
            r18.append(r17);
            GenericDescriptor r21 = findSymbol(r18.toString(), SearchFilter.AGGREGATES_ONLY);
            if (r21 != null) goto L15;
            r18.setLength(r19);
            goto L10
        L15:
            if (r16 == (-1)) goto L17;
            r18.setLength(r20);
            r18.append(r10);
            r14 = findSymbol(r18.toString(), r12);
        L18:
            r13 = r18.toString();
            goto L19
        L17:
            r14 = r21;
            goto L18
        L12:
            r14 = findSymbol(r10, r12);
            r13 = r10;
            goto L19
        L8:
            r17 = r10.substring(0, r16);
            goto L9
        }

        public GenericDescriptor findSymbol(String r10, SearchFilter r11) {
            GenericDescriptor r12 = this.descriptorsByName.get(r10);
            if (r12 != null) goto L5;
        L15:
            Iterator<FileDescriptor> r13 = this.dependencies.iterator();
        L17:
            if (r13.hasNext() == false) goto L31;
            GenericDescriptor r14 = FileDescriptor.access$1400(r13.next()).descriptorsByName.get(r10);
            if (r14 == null) goto L17;
            if (r11 == SearchFilter.ALL_SYMBOLS) goto L30;
            if (r11 != SearchFilter.TYPES_ONLY) goto L27;
            if (isType(r14) == true) goto L30;
        L27:
            if (r11 != SearchFilter.AGGREGATES_ONLY) goto L17;
            if (isAggregate(r14) == false) goto L17;
        L30:
            return r14;
        L31:
            return null;
        L5:
            if (r11 != SearchFilter.ALL_SYMBOLS) goto L7;
        L14:
            return r12;
        L7:
            if (r11 != SearchFilter.TYPES_ONLY) goto L11;
            if (isType(r12) == true) goto L14;
        L11:
            if (r11 != SearchFilter.AGGREGATES_ONLY) goto L15;
            if (isAggregate(r12) == false) goto L15;
            goto L14
        }
    }

    public static class DescriptorValidationException extends Exception {
        private static final long serialVersionUID = 5750205775490483148L;
        private final String description;
        private final String name;
        private final Message proto;

        public /* synthetic */ DescriptorValidationException(FileDescriptor r10, String r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        public String getDescription() {
            return this.description;
        }

        public Message getProblemProto() {
            return this.proto;
        }

        public String getProblemSymbolName() {
            return this.name;
        }

        public /* synthetic */ DescriptorValidationException(GenericDescriptor r10, String r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        public /* synthetic */ DescriptorValidationException(GenericDescriptor r10, String r11, Throwable r12, AnonymousClass1 r13) {
            this(r10, r11, r12);
        }

        private DescriptorValidationException(GenericDescriptor r10, String r11) {
            super(r10.getFullName() + ": " + r11);
            this.name = r10.getFullName();
            this.proto = r10.toProto();
            this.description = r11;
        }

        private DescriptorValidationException(GenericDescriptor r10, String r11, Throwable r12) {
            this(r10, r11);
            initCause(r12);
        }

        private DescriptorValidationException(FileDescriptor r10, String r11) {
            super(r10.getName() + ": " + r11);
            this.name = r10.getName();
            this.proto = r10.toProto();
            this.description = r11;
        }
    }

    public static final class EnumDescriptor extends GenericDescriptor implements Internal.EnumLiteMap<EnumValueDescriptor> {
        private final Descriptor containingType;
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private DescriptorProtos.EnumDescriptorProto proto;
        private final WeakHashMap<Integer, WeakReference<EnumValueDescriptor>> unknownValues;
        private EnumValueDescriptor[] values;

        public /* synthetic */ EnumDescriptor(DescriptorProtos.EnumDescriptorProto r10, FileDescriptor r11, Descriptor r12, int r13, AnonymousClass1 r14) throws DescriptorValidationException {
            this(r10, r11, r12, r13);
        }

        public static /* synthetic */ void access$1100(EnumDescriptor r10, DescriptorProtos.EnumDescriptorProto r11) {
            r10.setProto(r11);
        }

        private void setProto(DescriptorProtos.EnumDescriptorProto r10) {
            this.proto = r10;
            int r11 = 0;
        L3:
            EnumValueDescriptor[] r12 = this.values;
            if (r11 >= r12.length) goto L6;
            EnumValueDescriptor.access$2700(r12[r11], r10.getValue(r11));
            r11 = r11 + 1;
            goto L3
        }

        public EnumValueDescriptor findValueByName(String r10) {
            GenericDescriptor r11 = FileDescriptor.access$1400(this.file).findSymbol(this.fullName + '.' + r10);
            if (r11 != null) goto L5;
            return null;
        L5:
            if ((r11 instanceof EnumValueDescriptor) == true) goto L7;
            return null;
        L7:
            return (EnumValueDescriptor) r11;
        }

        @Override // com.google.protobuf.Internal.EnumLiteMap
        public /* bridge */ /* synthetic */ Internal.EnumLite findValueByNumber(int r10) {
            return findValueByNumber(r10);
        }

        public EnumValueDescriptor findValueByNumberCreatingIfUnknown(int r10) {
            EnumValueDescriptor r11 = findValueByNumber(r10);
            if (r11 == null) goto L5;
            return r11;
        L5:
            monitor-enter(this);
            Integer r12 = new Integer(r10);     // Catch: Throwable -> L9
            WeakReference<EnumValueDescriptor> r13 = this.unknownValues.get(r12);     // Catch: Throwable -> L9
            if (r13 == null) goto L11;
            r11 = r13.get();     // Catch: Throwable -> L9
        L11:
            if (r11 != null) goto L13;
            r11 = new EnumValueDescriptor(this.file, this, r12, null);     // Catch: Throwable -> L9
            this.unknownValues.put(r12, new WeakReference(r11));     // Catch: Throwable -> L9
        L13:
            monitor-exit(this);     // Catch: Throwable -> L9
            return r11;
        L9:
            th = move-exception;
            throw th;
        }

        public Descriptor getContainingType() {
            return this.containingType;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        public int getIndex() {
            return this.index;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        public DescriptorProtos.EnumOptions getOptions() {
            return this.proto.getOptions();
        }

        public int getUnknownEnumValueDescriptorCount() {
            return this.unknownValues.size();
        }

        public List<EnumValueDescriptor> getValues() {
            return Collections.unmodifiableList(Arrays.asList(this.values));
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public /* bridge */ /* synthetic */ Message toProto() {
            return toProto();
        }

        private EnumDescriptor(DescriptorProtos.EnumDescriptorProto r10, FileDescriptor r11, Descriptor r12, int r13) throws DescriptorValidationException {
            this.unknownValues = new WeakHashMap();
            this.index = r13;
            this.proto = r10;
            this.fullName = Descriptors.access$1600(r11, r12, r10.getName());
            this.file = r11;
            this.containingType = r12;
            if (r10.getValueCount() == 0) goto L11;
            this.values = new EnumValueDescriptor[r10.getValueCount()];
            int r14 = 0;
        L6:
            if (r14 >= r10.getValueCount()) goto L8;
            int r15 = r14;
            this.values[r14] = new EnumValueDescriptor(r10.getValue(r14), r11, this, r15, null);
            r14 = r14 + 1;
            goto L6
        L8:
            FileDescriptor.access$1400(r11).addSymbol(this);
            return;
        L11:
            throw new DescriptorValidationException(this, "Enums must contain at least one value.", null);
        }

        @Override // com.google.protobuf.Internal.EnumLiteMap
        public EnumValueDescriptor findValueByNumber(int r10) {
            return (EnumValueDescriptor) DescriptorPool.access$2400(FileDescriptor.access$1400(this.file)).get(new DescriptorPool.DescriptorIntPair(this, r10));
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.EnumDescriptorProto toProto() {
            return this.proto;
        }
    }

    public static final class EnumValueDescriptor extends GenericDescriptor implements Internal.EnumLite {
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private Integer number;
        private DescriptorProtos.EnumValueDescriptorProto proto;
        private final EnumDescriptor type;

        public /* synthetic */ EnumValueDescriptor(DescriptorProtos.EnumValueDescriptorProto r10, FileDescriptor r11, EnumDescriptor r12, int r13, AnonymousClass1 r14) throws DescriptorValidationException {
            this(r10, r11, r12, r13);
        }

        public static /* synthetic */ void access$2700(EnumValueDescriptor r10, DescriptorProtos.EnumValueDescriptorProto r11) {
            r10.setProto(r11);
        }

        private void setProto(DescriptorProtos.EnumValueDescriptorProto r10) {
            this.proto = r10;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        public int getIndex() {
            return this.index;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.proto.getNumber();
        }

        public DescriptorProtos.EnumValueOptions getOptions() {
            return this.proto.getOptions();
        }

        public EnumDescriptor getType() {
            return this.type;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public /* bridge */ /* synthetic */ Message toProto() {
            return toProto();
        }

        public String toString() {
            return this.proto.getName();
        }

        public /* synthetic */ EnumValueDescriptor(FileDescriptor r10, EnumDescriptor r11, Integer r12, AnonymousClass1 r13) {
            this(r10, r11, r12);
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.EnumValueDescriptorProto toProto() {
            return this.proto;
        }

        private EnumValueDescriptor(DescriptorProtos.EnumValueDescriptorProto r10, FileDescriptor r11, EnumDescriptor r12, int r13) throws DescriptorValidationException {
            this.index = r13;
            this.proto = r10;
            this.file = r11;
            this.type = r12;
            this.fullName = r12.getFullName() + '.' + r10.getName();
            FileDescriptor.access$1400(r11).addSymbol(this);
            FileDescriptor.access$1400(r11).addEnumValueByNumber(this);
        }

        private EnumValueDescriptor(FileDescriptor r10, EnumDescriptor r11, Integer r12) {
            DescriptorProtos.EnumValueDescriptorProto r13 = DescriptorProtos.EnumValueDescriptorProto.newBuilder().setName("UNKNOWN_ENUM_VALUE_" + r11.getName() + "_" + r12).setNumber(r12.intValue()).build();
            this.index = -1;
            this.proto = r13;
            this.file = r10;
            this.type = r11;
            this.fullName = r11.getFullName() + '.' + r13.getName();
            this.number = r12;
        }
    }

    public static final class FieldDescriptor extends GenericDescriptor implements Comparable<FieldDescriptor>, FieldSet.FieldDescriptorLite<FieldDescriptor> {
        private static final WireFormat.FieldType[] table = null;
        private OneofDescriptor containingOneof;
        private Descriptor containingType;
        private Object defaultValue;
        private EnumDescriptor enumType;
        private final Descriptor extensionScope;
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private final String jsonName;
        private Descriptor messageType;
        private DescriptorProtos.FieldDescriptorProto proto;
        private Type type;

        public static final enum JavaType extends java.lang.Enum<JavaType> {
            private static final /* synthetic */ JavaType[] $VALUES = null;
            public static final JavaType BOOLEAN = null;
            public static final JavaType BYTE_STRING = null;
            public static final JavaType DOUBLE = null;
            public static final JavaType ENUM = null;
            public static final JavaType FLOAT = null;
            public static final JavaType INT = null;
            public static final JavaType LONG = null;
            public static final JavaType MESSAGE = null;
            public static final JavaType STRING = null;
            private final Object defaultDefault;

            static {
                JavaType r10 = new JavaType("INT", 0, 0);
                INT = r10;
                JavaType r11 = new JavaType("LONG", 1, 0L);
                LONG = r11;
                JavaType r12 = new JavaType("FLOAT", 2, Float.valueOf(0.0f));
                FLOAT = r12;
                JavaType r13 = new JavaType("DOUBLE", 3, Double.valueOf(0.0d));
                DOUBLE = r13;
                JavaType r14 = new JavaType("BOOLEAN", 4, Boolean.FALSE);
                BOOLEAN = r14;
                JavaType r15 = new JavaType("STRING", 5, "");
                STRING = r15;
                JavaType r16 = new JavaType("BYTE_STRING", 6, ByteString.EMPTY);
                BYTE_STRING = r16;
                JavaType r17 = new JavaType("ENUM", 7, null);
                ENUM = r17;
                JavaType r18 = new JavaType("MESSAGE", 8, null);
                MESSAGE = r18;
                $VALUES = new JavaType[]{r10, r11, r12, r13, r14, r15, r16, r17, r18};
            }

            private JavaType(String r10, int r11, Object r12) {
                super(r10, r11);
                this.defaultDefault = r12;
            }

            public static /* synthetic */ Object access$2300(JavaType r10) {
                return r10.defaultDefault;
            }

            public static JavaType valueOf(String r10) {
                return (JavaType) java.lang.Enum.valueOf(JavaType.class, r10);
            }

            public static JavaType[] values() {
                return (JavaType[]) $VALUES.clone();
            }
        }

        public static final enum Type extends java.lang.Enum<Type> {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final Type BOOL = null;
            public static final Type BYTES = null;
            public static final Type DOUBLE = null;
            public static final Type ENUM = null;
            public static final Type FIXED32 = null;
            public static final Type FIXED64 = null;
            public static final Type FLOAT = null;
            public static final Type GROUP = null;
            public static final Type INT32 = null;
            public static final Type INT64 = null;
            public static final Type MESSAGE = null;
            public static final Type SFIXED32 = null;
            public static final Type SFIXED64 = null;
            public static final Type SINT32 = null;
            public static final Type SINT64 = null;
            public static final Type STRING = null;
            public static final Type UINT32 = null;
            public static final Type UINT64 = null;
            private JavaType javaType;

            static {
                Type r10 = new Type("DOUBLE", 0, JavaType.DOUBLE);
                DOUBLE = r10;
                Type r11 = new Type("FLOAT", 1, JavaType.FLOAT);
                FLOAT = r11;
                JavaType r15 = JavaType.LONG;
                Type r12 = new Type("INT64", 2, r15);
                INT64 = r12;
                Type r13 = new Type("UINT64", 3, r15);
                UINT64 = r13;
                JavaType r14 = JavaType.INT;
                Type r16 = new Type("INT32", 4, r14);
                INT32 = r16;
                Type r17 = new Type("FIXED64", 5, r15);
                FIXED64 = r17;
                Type r18 = new Type("FIXED32", 6, r14);
                FIXED32 = r18;
                Type r19 = new Type("BOOL", 7, JavaType.BOOLEAN);
                BOOL = r19;
                Type r20 = new Type("STRING", 8, JavaType.STRING);
                STRING = r20;
                JavaType r110 = JavaType.MESSAGE;
                Type r111 = new Type("GROUP", 9, r110);
                GROUP = r111;
                Type r112 = new Type("MESSAGE", 10, r110);
                MESSAGE = r112;
                Type r113 = new Type("BYTES", 11, JavaType.BYTE_STRING);
                BYTES = r113;
                Type r21 = new Type("UINT32", 12, r14);
                UINT32 = r21;
                Type r22 = new Type("ENUM", 13, JavaType.ENUM);
                ENUM = r22;
                Type r23 = new Type("SFIXED32", 14, r14);
                SFIXED32 = r23;
                Type r24 = new Type("SFIXED64", 15, r15);
                SFIXED64 = r24;
                Type r25 = new Type("SINT32", 16, r14);
                SINT32 = r25;
                Type r26 = new Type("SINT64", 17, r15);
                SINT64 = r26;
                $VALUES = new Type[]{r10, r11, r12, r13, r16, r17, r18, r19, r20, r111, r112, r113, r21, r22, r23, r24, r25, r26};
            }

            private Type(String r10, int r11, JavaType r12) {
                super(r10, r11);
                this.javaType = r12;
            }

            public static Type valueOf(String r10) {
                return (Type) java.lang.Enum.valueOf(Type.class, r10);
            }

            public static Type[] values() {
                return (Type[]) $VALUES.clone();
            }

            public JavaType getJavaType() {
                return this.javaType;
            }

            public DescriptorProtos.FieldDescriptorProto.Type toProto() {
                return DescriptorProtos.FieldDescriptorProto.Type.forNumber(ordinal() + 1);
            }

            public static Type valueOf(DescriptorProtos.FieldDescriptorProto.Type r10) {
                return values()[r10.getNumber() - 1];
            }
        }

        static {
            table = WireFormat.FieldType.values();
            if (Type.values().length != DescriptorProtos.FieldDescriptorProto.Type.values().length) goto L6;
            return;
        L6:
            throw new RuntimeException("descriptor.proto has a new declared type but Descriptors.java wasn't updated.");
        }

        public /* synthetic */ FieldDescriptor(DescriptorProtos.FieldDescriptorProto r10, FileDescriptor r11, Descriptor r12, int r13, boolean r14, AnonymousClass1 r15) throws DescriptorValidationException {
            this(r10, r11, r12, r13, r14);
        }

        public static /* synthetic */ void access$1300(FieldDescriptor r10, DescriptorProtos.FieldDescriptorProto r11) {
            r10.setProto(r11);
        }

        public static /* synthetic */ void access$900(FieldDescriptor r10) throws DescriptorValidationException {
            r10.crossLink();
        }

        private void crossLink() throws DescriptorValidationException {
            AnonymousClass1 r10 = null;
            if (this.proto.hasExtendee() == false) goto L14;
            GenericDescriptor r11 = FileDescriptor.access$1400(this.file).lookupSymbol(this.proto.getExtendee(), this, DescriptorPool.SearchFilter.TYPES_ONLY);
            if ((r11 instanceof Descriptor) == false) goto L12;
            this.containingType = (Descriptor) r11;
            if (getContainingType().isExtensionNumber(getNumber()) == true) goto L14;
            throw new DescriptorValidationException(this, TokenParser.DQUOTE + getContainingType().getFullName() + "\" does not declare " + getNumber() + " as an extension number.", r10);
        L12:
            throw new DescriptorValidationException(this, TokenParser.DQUOTE + this.proto.getExtendee() + "\" is not a message type.", r10);
        L14:
            if (this.proto.hasTypeName() == false) goto L46;
            GenericDescriptor r12 = FileDescriptor.access$1400(this.file).lookupSymbol(this.proto.getTypeName(), this, DescriptorPool.SearchFilter.TYPES_ONLY);
            if (this.proto.hasType() == true) goto L26;
            if ((r12 instanceof Descriptor) == false) goto L21;
            this.type = Type.MESSAGE;
            goto L26
        L21:
            if ((r12 instanceof EnumDescriptor) == false) goto L24;
            this.type = Type.ENUM;
            goto L26
        L24:
            throw new DescriptorValidationException(this, TokenParser.DQUOTE + this.proto.getTypeName() + "\" is not a type.", r10);
        L26:
            if (getJavaType() != JavaType.MESSAGE) goto L37;
            if ((r12 instanceof Descriptor) == false) goto L35;
            this.messageType = (Descriptor) r12;
            if (this.proto.hasDefaultValue() == false) goto L50;
            throw new DescriptorValidationException(this, "Messages can't have default values.", r10);
        L50:
            if (this.proto.getOptions().getPacked() == false) goto L57;
            if (isPackable() == true) goto L57;
            throw new DescriptorValidationException(this, "[packed = true] can only be specified for repeated primitive fields.", r10);
        L57:
            if (this.proto.hasDefaultValue() == false) goto L110;
            if (isRepeated() == true) goto L108;
        L66:
            e = move-exception;
            throw new DescriptorValidationException(this, "Could not parse default value: \"" + this.proto.getDefaultValue() + TokenParser.DQUOTE, e, r10);
        L62:
            switch(AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[getType().ordinal()]) {
                case 1: goto L103;
                case 2: goto L103;
                case 3: goto L103;
                case 4: goto L102;
                case 5: goto L102;
                case 6: goto L101;
                case 7: goto L101;
                case 8: goto L101;
                case 9: goto L100;
                case 10: goto L100;
                case 11: goto L91;
                case 12: goto L81;
                case 13: goto L79;
                case 14: goto L78;
                case 15: goto L141;
                case 16: goto L68;
                case 17: goto L65;
                case 18: goto L65;
                default: goto L120;
            };
        L68:
            EnumValueDescriptor r13 = this.enumType.findValueByName(this.proto.getDefaultValue());     // Catch: NumberFormatException -> L66
            this.defaultValue = r13;     // Catch: NumberFormatException -> L66
            if (r13 != null) goto L120;
            throw new DescriptorValidationException(this, "Unknown enum default value: \"" + this.proto.getDefaultValue() + TokenParser.DQUOTE, r10);     // Catch: NumberFormatException -> L66
        L78:
            this.defaultValue = this.proto.getDefaultValue();     // Catch: NumberFormatException -> L66
            goto L120
        L79:
            this.defaultValue = Boolean.valueOf(this.proto.getDefaultValue());     // Catch: NumberFormatException -> L66
            goto L120
        L100:
            this.defaultValue = Long.valueOf(TextFormat.parseUInt64(this.proto.getDefaultValue()));     // Catch: NumberFormatException -> L66
            goto L120
        L101:
            this.defaultValue = Long.valueOf(TextFormat.parseInt64(this.proto.getDefaultValue()));     // Catch: NumberFormatException -> L66
            goto L120
        L102:
            this.defaultValue = Integer.valueOf(TextFormat.parseUInt32(this.proto.getDefaultValue()));     // Catch: NumberFormatException -> L66
            goto L120
        L103:
            this.defaultValue = Integer.valueOf(TextFormat.parseInt32(this.proto.getDefaultValue()));     // Catch: NumberFormatException -> L66
            goto L120
        L141:
            this.defaultValue = TextFormat.unescapeBytes(this.proto.getDefaultValue());     // Catch: NumberFormatException -> L66 TextFormat.InvalidEscapeSequenceException -> L75
        L75:
            e = move-exception;
            throw new DescriptorValidationException(this, "Couldn't parse default value: " + e.getMessage(), e, r10);     // Catch: NumberFormatException -> L66
        L65:
            throw new DescriptorValidationException(this, "Message type had default value.", r10);     // Catch: NumberFormatException -> L66
        L81:
            if (this.proto.getDefaultValue().equals("inf") == false) goto L84;
            this.defaultValue = Double.valueOf(Double.POSITIVE_INFINITY);     // Catch: NumberFormatException -> L66
            goto L120
        L84:
            if (this.proto.getDefaultValue().equals("-inf") == false) goto L87;
            this.defaultValue = Double.valueOf(Double.NEGATIVE_INFINITY);     // Catch: NumberFormatException -> L66
            goto L120
        L87:
            if (this.proto.getDefaultValue().equals("nan") == false) goto L89;
            this.defaultValue = Double.valueOf(Double.NaN);     // Catch: NumberFormatException -> L66
            goto L120
        L89:
            this.defaultValue = Double.valueOf(this.proto.getDefaultValue());     // Catch: NumberFormatException -> L66
            goto L120
        L91:
            if (this.proto.getDefaultValue().equals("inf") == false) goto L94;
            this.defaultValue = Float.valueOf(Float.POSITIVE_INFINITY);     // Catch: NumberFormatException -> L66
            goto L120
        L94:
            if (this.proto.getDefaultValue().equals("-inf") == false) goto L97;
            this.defaultValue = Float.valueOf(Float.NEGATIVE_INFINITY);     // Catch: NumberFormatException -> L66
            goto L120
        L97:
            if (this.proto.getDefaultValue().equals("nan") == false) goto L99;
            this.defaultValue = Float.valueOf(Float.NaN);     // Catch: NumberFormatException -> L66
            goto L120
        L99:
            this.defaultValue = Float.valueOf(this.proto.getDefaultValue());     // Catch: NumberFormatException -> L66
        L120:
            if (isExtension() == true) goto L122;
            FileDescriptor.access$1400(this.file).addFieldByNumber(this);
        L122:
            Descriptor r14 = this.containingType;
            if (r14 != null) goto L125;
            return;
        L125:
            if (r14.getOptions().getMessageSetWireFormat() == true) goto L127;
            return;
        L127:
            if (isExtension() == false) goto L136;
            if (isOptional() == false) goto L134;
            if (getType() != Type.MESSAGE) goto L134;
            return;
        L134:
            throw new DescriptorValidationException(this, "Extensions of MessageSets must be optional messages.", r10);
        L136:
            throw new DescriptorValidationException(this, "MessageSets cannot have fields, only extensions.", r10);
        L108:
            throw new DescriptorValidationException(this, "Repeated fields cannot have default values.", r10);
        L110:
            if (isRepeated() == false) goto L112;
            this.defaultValue = Collections.emptyList();
            goto L120
        L112:
            int r15 = AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[getJavaType().ordinal()];
            if (r15 != 1) goto L115;
            this.defaultValue = this.enumType.getValues().get(0);
            goto L120
        L115:
            if (r15 == 2) goto L117;
            this.defaultValue = JavaType.access$2300(getJavaType());
            goto L120
        L117:
            this.defaultValue = null;
            goto L120
        L35:
            throw new DescriptorValidationException(this, TokenParser.DQUOTE + this.proto.getTypeName() + "\" is not a message type.", r10);
        L37:
            if (getJavaType() != JavaType.ENUM) goto L44;
            if ((r12 instanceof EnumDescriptor) == false) goto L42;
            this.enumType = (EnumDescriptor) r12;
            goto L50
        L42:
            throw new DescriptorValidationException(this, TokenParser.DQUOTE + this.proto.getTypeName() + "\" is not an enum type.", r10);
        L44:
            throw new DescriptorValidationException(this, "Field with primitive type has type_name.", r10);
        L46:
            if (getJavaType() == JavaType.MESSAGE) goto L139;
            if (getJavaType() != JavaType.ENUM) goto L50;
        L139:
            throw new DescriptorValidationException(this, "Field with message or enum type missing type_name.", r10);
        }

        private static String fieldNameToLowerCamelCase(String r10) {
            StringBuilder r11 = new StringBuilder(r10.length());
            int r12 = 0;
            boolean r13 = false;
        L4:
            if (r12 >= r10.length()) goto L22;
            char r14 = r10.charAt(r12);
            Character r15 = Character.valueOf(r14);
            if (Character.isLowerCase(r14) == false) goto L12;
            if (r13 == false) goto L9;
            r11.append(Character.toUpperCase(r14));
        L10:
            r13 = false;
        L20:
            r12 = r12 + 1;
            goto L4
        L9:
            r11.append(r15);
            goto L10
        L12:
            if (Character.isUpperCase(r14) == false) goto L17;
            if (r12 != 0) goto L15;
            r11.append(Character.toLowerCase(r14));
            goto L10
        L15:
            r11.append(r15);
            goto L10
        L17:
            if (Character.isDigit(r14) == false) goto L19;
            r11.append(r15);
            goto L10
        L19:
            r13 = true;
            goto L20
        L22:
            return r11.toString();
        }

        private void setProto(DescriptorProtos.FieldDescriptorProto r10) {
            this.proto = r10;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(FieldDescriptor r10) {
            return compareTo2(r10);
        }

        public OneofDescriptor getContainingOneof() {
            return this.containingOneof;
        }

        public Descriptor getContainingType() {
            return this.containingType;
        }

        public Object getDefaultValue() {
            if (getJavaType() == JavaType.MESSAGE) goto L7;
            return this.defaultValue;
        L7:
            throw new UnsupportedOperationException("FieldDescriptor.getDefaultValue() called on an embedded message field.");
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public /* bridge */ /* synthetic */ Internal.EnumLiteMap getEnumType() {
            return getEnumType();
        }

        public Descriptor getExtensionScope() {
            if (isExtension() == false) goto L7;
            return this.extensionScope;
        L7:
            throw new UnsupportedOperationException("This field is not an extension.");
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        public int getIndex() {
            return this.index;
        }

        public JavaType getJavaType() {
            return this.type.getJavaType();
        }

        public String getJsonName() {
            return this.jsonName;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.JavaType getLiteJavaType() {
            return getLiteType().getJavaType();
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.FieldType getLiteType() {
            return table[this.type.ordinal()];
        }

        public Descriptor getMessageType() {
            if (getJavaType() != JavaType.MESSAGE) goto L7;
            return this.messageType;
        L7:
            throw new UnsupportedOperationException("This field is not of message type.");
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public int getNumber() {
            return this.proto.getNumber();
        }

        public DescriptorProtos.FieldOptions getOptions() {
            return this.proto.getOptions();
        }

        public Type getType() {
            return this.type;
        }

        public boolean hasDefaultValue() {
            return this.proto.hasDefaultValue();
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public MessageLite.Builder internalMergeFrom(MessageLite.Builder r10, MessageLite r11) {
            return ((Message.Builder) r10).mergeFrom((Message) r11);
        }

        public boolean isExtension() {
            return this.proto.hasExtendee();
        }

        public boolean isMapField() {
            if (getType() == Type.MESSAGE) goto L5;
        L9:
            return false;
        L5:
            if (isRepeated() == false) goto L9;
            if (getMessageType().getOptions().getMapEntry() == false) goto L9;
            return true;
        }

        public boolean isOptional() {
            if (this.proto.getLabel() != DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isPackable() {
            if (isRepeated() == true) goto L5;
        L7:
            return false;
        L5:
            if (getLiteType().isPackable() == false) goto L7;
            return true;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean isPacked() {
            if (isPackable() == true) goto L6;
            return false;
        L6:
            if (getFile().getSyntax() != FileDescriptor.Syntax.PROTO2) goto L10;
            return getOptions().getPacked();
        L10:
            if (getOptions().hasPacked() == true) goto L12;
        L13:
            return true;
        L12:
            if (getOptions().getPacked() == true) goto L13;
            return false;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean isRepeated() {
            if (this.proto.getLabel() != DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isRequired() {
            if (this.proto.getLabel() != DescriptorProtos.FieldDescriptorProto.Label.LABEL_REQUIRED) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean needsUtf8Check() {
            if (this.type == Type.STRING) goto L7;
            return false;
        L7:
            if (getContainingType().getOptions().getMapEntry() == false) goto L10;
            return true;
        L10:
            if (getFile().getSyntax() != FileDescriptor.Syntax.PROTO3) goto L13;
            return true;
        L13:
            return getFile().getOptions().getJavaStringCheckUtf8();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public /* bridge */ /* synthetic */ Message toProto() {
            return toProto();
        }

        public String toString() {
            return getFullName();
        }

        private FieldDescriptor(DescriptorProtos.FieldDescriptorProto r10, FileDescriptor r11, Descriptor r12, int r13, boolean r14) throws DescriptorValidationException {
            this.index = r13;
            this.proto = r10;
            this.fullName = Descriptors.access$1600(r11, r12, r10.getName());
            this.file = r11;
            if (r10.hasJsonName() == false) goto L5;
            this.jsonName = r10.getJsonName();
        L7:
            if (r10.hasType() == false) goto L9;
            this.type = Type.valueOf(r10.getType());
        L9:
            AnonymousClass1 r15 = null;
            if (getNumber() <= 0) goto L43;
            if (r14 == false) goto L26;
            if (r10.hasExtendee() == false) goto L24;
            this.containingType = null;
            if (r12 == null) goto L17;
            this.extensionScope = r12;
        L19:
            if (r10.hasOneofIndex() == true) goto L22;
            this.containingOneof = null;
        L38:
            FileDescriptor.access$1400(r11).addSymbol(this);
            return;
        L22:
            throw new DescriptorValidationException(this, "FieldDescriptorProto.oneof_index set for extension field.", r15);
        L17:
            this.extensionScope = null;
            goto L19
        L24:
            throw new DescriptorValidationException(this, "FieldDescriptorProto.extendee not set for extension field.", r15);
        L26:
            if (r10.hasExtendee() == true) goto L41;
            this.containingType = r12;
            if (r10.hasOneofIndex() == true) goto L30;
            this.containingOneof = null;
        L37:
            this.extensionScope = null;
            goto L38
        L30:
            if (r10.getOneofIndex() < 0) goto L35;
            if (r10.getOneofIndex() >= r12.toProto().getOneofDeclCount()) goto L35;
            OneofDescriptor r16 = r12.getOneofs().get(r10.getOneofIndex());
            this.containingOneof = r16;
            OneofDescriptor.access$1908(r16);
        L35:
            throw new DescriptorValidationException(this, "FieldDescriptorProto.oneof_index is out of range for type " + r12.getName(), r15);
        L41:
            throw new DescriptorValidationException(this, "FieldDescriptorProto.extendee set for non-extension field.", r15);
        L43:
            throw new DescriptorValidationException(this, "Field numbers must be positive integers.", r15);
        L5:
            this.jsonName = fieldNameToLowerCamelCase(r10.getName());
            goto L7
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(FieldDescriptor r10) {
            if (r10.containingType != this.containingType) goto L7;
            return getNumber() - r10.getNumber();
        L7:
            throw new IllegalArgumentException("FieldDescriptors can only be compared to other FieldDescriptors for fields of the same message type.");
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public EnumDescriptor getEnumType() {
            if (getJavaType() != JavaType.ENUM) goto L7;
            return this.enumType;
        L7:
            throw new UnsupportedOperationException("This field is not of enum type.");
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.FieldDescriptorProto toProto() {
            return this.proto;
        }
    }

    public static final class FileDescriptor extends GenericDescriptor {
        private final FileDescriptor[] dependencies;
        private final EnumDescriptor[] enumTypes;
        private final FieldDescriptor[] extensions;
        private final Descriptor[] messageTypes;
        private final DescriptorPool pool;
        private DescriptorProtos.FileDescriptorProto proto;
        private final FileDescriptor[] publicDependencies;
        private final ServiceDescriptor[] services;

        public interface InternalDescriptorAssigner {
            ExtensionRegistry assignDescriptors(FileDescriptor r10);
        }

        public static final enum Syntax extends java.lang.Enum<Syntax> {
            private static final /* synthetic */ Syntax[] $VALUES = null;
            public static final Syntax PROTO2 = null;
            public static final Syntax PROTO3 = null;
            public static final Syntax UNKNOWN = null;
            private final String name;

            static {
                Syntax r10 = new Syntax("UNKNOWN", 0, "unknown");
                UNKNOWN = r10;
                Syntax r11 = new Syntax("PROTO2", 1, "proto2");
                PROTO2 = r11;
                Syntax r12 = new Syntax("PROTO3", 2, "proto3");
                PROTO3 = r12;
                $VALUES = new Syntax[]{r10, r11, r12};
            }

            private Syntax(String r10, int r11, String r12) {
                super(r10, r11);
                this.name = r12;
            }

            public static /* synthetic */ String access$000(Syntax r10) {
                return r10.name;
            }

            public static Syntax valueOf(String r10) {
                return (Syntax) java.lang.Enum.valueOf(Syntax.class, r10);
            }

            public static Syntax[] values() {
                return (Syntax[]) $VALUES.clone();
            }
        }

        private FileDescriptor(DescriptorProtos.FileDescriptorProto r12, FileDescriptor[] r13, DescriptorPool r14, boolean r15) throws DescriptorValidationException {
            this.pool = r14;
            this.proto = r12;
            this.dependencies = (FileDescriptor[]) r13.clone();
            HashMap r10 = new HashMap();
            int r11 = r13.length;
            int r16 = 0;
            int r17 = 0;
        L3:
            if (r17 >= r11) goto L5;
            FileDescriptor r18 = r13[r17];
            r10.put(r18.getName(), r18);
            r17 = r17 + 1;
            goto L3
        L5:
            ArrayList r19 = new ArrayList();
            int r20 = 0;
        L6:
            AnonymousClass1 r21 = null;
            if (r20 >= r12.getPublicDependencyCount()) goto L22;
            int r22 = r12.getPublicDependency(r20);
            if (r22 < 0) goto L21;
            if (r22 >= r12.getDependencyCount()) goto L21;
            String r23 = r12.getDependency(r22);
            FileDescriptor r24 = (FileDescriptor) r10.get(r23);
            if (r24 != null) goto L18;
            if (r15 == true) goto L19;
            throw new DescriptorValidationException(this, "Invalid public dependency: " + r23, r21);
        L19:
            r20 = r20 + 1;
            goto L6
        L18:
            r19.add(r24);
        L21:
            throw new DescriptorValidationException(this, "Invalid public dependency index.", r21);
        L22:
            FileDescriptor[] r110 = new FileDescriptor[r19.size()];
            this.publicDependencies = r110;
            r19.toArray(r110);
            r14.addPackage(getPackage(), this);
            this.messageTypes = new Descriptor[r12.getMessageTypeCount()];
            int r111 = 0;
        L24:
            if (r111 >= r12.getMessageTypeCount()) goto L26;
            this.messageTypes[r111] = new Descriptor(r12.getMessageType(r111), this, null, r111, null);
            r111 = r111 + 1;
            goto L24
        L26:
            this.enumTypes = new EnumDescriptor[r12.getEnumTypeCount()];
            int r112 = 0;
        L28:
            if (r112 >= r12.getEnumTypeCount()) goto L30;
            this.enumTypes[r112] = new EnumDescriptor(r12.getEnumType(r112), this, null, r112, null);
            r112 = r112 + 1;
            goto L28
        L30:
            this.services = new ServiceDescriptor[r12.getServiceCount()];
            int r113 = 0;
        L32:
            if (r113 >= r12.getServiceCount()) goto L34;
            this.services[r113] = new ServiceDescriptor(r12.getService(r113), this, r113, r21);
            r113 = r113 + 1;
            goto L32
        L34:
            this.extensions = new FieldDescriptor[r12.getExtensionCount()];
        L36:
            if (r16 >= r12.getExtensionCount()) goto L38;
            this.extensions[r16] = new FieldDescriptor(r12.getExtension(r16), this, null, r16, true, null);
            r16 = r16 + 1;
            goto L36
        }

        public static /* synthetic */ DescriptorPool access$1400(FileDescriptor r10) {
            return r10.pool;
        }

        public static FileDescriptor buildFrom(DescriptorProtos.FileDescriptorProto r10, FileDescriptor[] r11) throws DescriptorValidationException {
            return buildFrom(r10, r11, false);
        }

        private void crossLink() throws DescriptorValidationException {
            Descriptor[] r10 = this.messageTypes;
            int r11 = r10.length;
            int r12 = 0;
            int r13 = 0;
        L3:
            if (r13 >= r11) goto L5;
            Descriptor.access$700(r10[r13]);
            r13 = r13 + 1;
            goto L3
        L5:
            ServiceDescriptor[] r14 = this.services;
            int r15 = r14.length;
            int r16 = 0;
        L6:
            if (r16 >= r15) goto L8;
            ServiceDescriptor.access$800(r14[r16]);
            r16 = r16 + 1;
            goto L6
        L8:
            FieldDescriptor[] r17 = this.extensions;
            int r18 = r17.length;
        L9:
            if (r12 >= r18) goto L11;
            FieldDescriptor.access$900(r17[r12]);
            r12 = r12 + 1;
            goto L9
        }

        public static void internalBuildGeneratedFileFrom(String[] r10, FileDescriptor[] r11, InternalDescriptorAssigner r12) {
            StringBuilder r13 = new StringBuilder();
            int r14 = r10.length;
            int r15 = 0;
        L3:
            if (r15 >= r14) goto L5;
            r13.append(r10[r15]);
            r15 = r15 + 1;
            goto L3
        L5:
            byte[] r16 = r13.toString().getBytes(Internal.ISO_8859_1);
            DescriptorProtos.FileDescriptorProto r17 = DescriptorProtos.FileDescriptorProto.parseFrom(r16);     // Catch: InvalidProtocolBufferException -> L20
            FileDescriptor r18 = buildFrom(r17, r11, true);     // Catch: DescriptorValidationException -> L17
            ExtensionRegistry r19 = r12.assignDescriptors(r18);
            if (r19 != null) goto L23;
            return;
        L23:
            r18.setProto(DescriptorProtos.FileDescriptorProto.parseFrom(r16, r19));
            return;
        L13:
            e = move-exception;
            throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e);
        L17:
            e = move-exception;
            throw new IllegalArgumentException("Invalid embedded descriptor for \"" + r17.getName() + "\".", e);
        L20:
            e = move-exception;
            throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e);
        }

        public static void internalUpdateFileDescriptor(FileDescriptor r10, ExtensionRegistry r11) {
            r10.setProto(DescriptorProtos.FileDescriptorProto.parseFrom(r10.proto.toByteString(), r11));
            return;
        L6:
            e = move-exception;
            throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e);
        }

        private void setProto(DescriptorProtos.FileDescriptorProto r10) {
            this.proto = r10;
            int r11 = 0;
            int r12 = 0;
        L3:
            Descriptor[] r13 = this.messageTypes;
            if (r12 >= r13.length) goto L6;
            Descriptor.access$1000(r13[r12], r10.getMessageType(r12));
            r12 = r12 + 1;
            goto L3
        L6:
            int r14 = 0;
        L7:
            EnumDescriptor[] r15 = this.enumTypes;
            if (r14 >= r15.length) goto L10;
            EnumDescriptor.access$1100(r15[r14], r10.getEnumType(r14));
            r14 = r14 + 1;
            goto L7
        L10:
            int r16 = 0;
        L11:
            ServiceDescriptor[] r17 = this.services;
            if (r16 >= r17.length) goto L14;
            ServiceDescriptor.access$1200(r17[r16], r10.getService(r16));
            r16 = r16 + 1;
        L14:
            FieldDescriptor[] r18 = this.extensions;
            if (r11 >= r18.length) goto L17;
            FieldDescriptor.access$1300(r18[r11], r10.getExtension(r11));
            r11 = r11 + 1;
            goto L14
        }

        public EnumDescriptor findEnumTypeByName(String r10) {
            if (r10.indexOf(46) == (-1)) goto L6;
            return null;
        L6:
            if (getPackage().length() <= 0) goto L8;
            r10 = getPackage() + '.' + r10;
        L8:
            GenericDescriptor r11 = this.pool.findSymbol(r10);
            if (r11 != null) goto L11;
        L16:
            return null;
        L11:
            if ((r11 instanceof EnumDescriptor) == false) goto L16;
            if (r11.getFile() != this) goto L16;
            return (EnumDescriptor) r11;
        }

        public FieldDescriptor findExtensionByName(String r10) {
            if (r10.indexOf(46) == (-1)) goto L6;
            return null;
        L6:
            if (getPackage().length() <= 0) goto L8;
            r10 = getPackage() + '.' + r10;
        L8:
            GenericDescriptor r11 = this.pool.findSymbol(r10);
            if (r11 != null) goto L11;
        L16:
            return null;
        L11:
            if ((r11 instanceof FieldDescriptor) == false) goto L16;
            if (r11.getFile() != this) goto L16;
            return (FieldDescriptor) r11;
        }

        public Descriptor findMessageTypeByName(String r10) {
            if (r10.indexOf(46) == (-1)) goto L6;
            return null;
        L6:
            if (getPackage().length() <= 0) goto L8;
            r10 = getPackage() + '.' + r10;
        L8:
            GenericDescriptor r11 = this.pool.findSymbol(r10);
            if (r11 != null) goto L11;
        L16:
            return null;
        L11:
            if ((r11 instanceof Descriptor) == false) goto L16;
            if (r11.getFile() != this) goto L16;
            return (Descriptor) r11;
        }

        public ServiceDescriptor findServiceByName(String r10) {
            if (r10.indexOf(46) == (-1)) goto L6;
            return null;
        L6:
            if (getPackage().length() <= 0) goto L8;
            r10 = getPackage() + '.' + r10;
        L8:
            GenericDescriptor r11 = this.pool.findSymbol(r10);
            if (r11 != null) goto L11;
        L16:
            return null;
        L11:
            if ((r11 instanceof ServiceDescriptor) == false) goto L16;
            if (r11.getFile() != this) goto L16;
            return (ServiceDescriptor) r11;
        }

        public List<FileDescriptor> getDependencies() {
            return Collections.unmodifiableList(Arrays.asList(this.dependencies));
        }

        public List<EnumDescriptor> getEnumTypes() {
            return Collections.unmodifiableList(Arrays.asList(this.enumTypes));
        }

        public List<FieldDescriptor> getExtensions() {
            return Collections.unmodifiableList(Arrays.asList(this.extensions));
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.proto.getName();
        }

        public List<Descriptor> getMessageTypes() {
            return Collections.unmodifiableList(Arrays.asList(this.messageTypes));
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        public DescriptorProtos.FileOptions getOptions() {
            return this.proto.getOptions();
        }

        public String getPackage() {
            return this.proto.getPackage();
        }

        public List<FileDescriptor> getPublicDependencies() {
            return Collections.unmodifiableList(Arrays.asList(this.publicDependencies));
        }

        public List<ServiceDescriptor> getServices() {
            return Collections.unmodifiableList(Arrays.asList(this.services));
        }

        public Syntax getSyntax() {
            Syntax r10 = Syntax.PROTO3;
            if (Syntax.access$000(r10).equals(this.proto.getSyntax()) == false) goto L6;
            return r10;
        L6:
            return Syntax.PROTO2;
        }

        public boolean supportsUnknownEnumValue() {
            if (getSyntax() != Syntax.PROTO3) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public /* bridge */ /* synthetic */ Message toProto() {
            return toProto();
        }

        public static FileDescriptor buildFrom(DescriptorProtos.FileDescriptorProto r10, FileDescriptor[] r11, boolean r12) throws DescriptorValidationException {
            FileDescriptor r13 = new FileDescriptor(r10, r11, new DescriptorPool(r11, r12), r12);
            r13.crossLink();
            return r13;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.FileDescriptorProto toProto() {
            return this.proto;
        }

        public static void internalBuildGeneratedFileFrom(String[] r10, Class<?> r11, String[] r12, String[] r13, InternalDescriptorAssigner r14) {
            ArrayList r15 = new ArrayList();
            int r16 = 0;
        L4:
            if (r16 >= r12.length) goto L9;
            r15.add((FileDescriptor) r11.getClassLoader().loadClass(r12[r16]).getField("descriptor").get(null));     // Catch: Exception -> L7
        L8:
            r16 = r16 + 1;
        L7:
            Descriptors.access$100().warning("Descriptors for \"" + r13[r16] + "\" can not be found.");
            goto L8
        L9:
            FileDescriptor[] r17 = new FileDescriptor[r15.size()];
            r15.toArray(r17);
            internalBuildGeneratedFileFrom(r10, r17, r14);
        }

        public FileDescriptor(String r10, Descriptor r11) throws DescriptorValidationException {
            DescriptorPool r12 = new DescriptorPool(new FileDescriptor[0], true);
            this.pool = r12;
            this.proto = DescriptorProtos.FileDescriptorProto.newBuilder().setName(r11.getFullName() + ".placeholder.proto").setPackage(r10).addMessageType(r11.toProto()).build();
            this.dependencies = new FileDescriptor[0];
            this.publicDependencies = new FileDescriptor[0];
            this.messageTypes = new Descriptor[]{r11};
            this.enumTypes = new EnumDescriptor[0];
            this.services = new ServiceDescriptor[0];
            this.extensions = new FieldDescriptor[0];
            r12.addPackage(r10, this);
            r12.addSymbol(r11);
        }
    }

    public static abstract class GenericDescriptor {
        public GenericDescriptor() {
        }

        public abstract FileDescriptor getFile();

        public abstract String getFullName();

        public abstract String getName();

        public abstract Message toProto();
    }

    public static final class MethodDescriptor extends GenericDescriptor {
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private Descriptor inputType;
        private Descriptor outputType;
        private DescriptorProtos.MethodDescriptorProto proto;
        private final ServiceDescriptor service;

        public /* synthetic */ MethodDescriptor(DescriptorProtos.MethodDescriptorProto r10, FileDescriptor r11, ServiceDescriptor r12, int r13, AnonymousClass1 r14) throws DescriptorValidationException {
            this(r10, r11, r12, r13);
        }

        public static /* synthetic */ void access$2900(MethodDescriptor r10) throws DescriptorValidationException {
            r10.crossLink();
        }

        public static /* synthetic */ void access$3000(MethodDescriptor r10, DescriptorProtos.MethodDescriptorProto r11) {
            r10.setProto(r11);
        }

        private void crossLink() throws DescriptorValidationException {
            DescriptorPool r10 = FileDescriptor.access$1400(this.file);
            String r11 = this.proto.getInputType();
            DescriptorPool.SearchFilter r12 = DescriptorPool.SearchFilter.TYPES_ONLY;
            GenericDescriptor r13 = r10.lookupSymbol(r11, this, r12);
            AnonymousClass1 r14 = null;
            if ((r13 instanceof Descriptor) == false) goto L11;
            this.inputType = (Descriptor) r13;
            GenericDescriptor r15 = FileDescriptor.access$1400(this.file).lookupSymbol(this.proto.getOutputType(), this, r12);
            if ((r15 instanceof Descriptor) == false) goto L9;
            this.outputType = (Descriptor) r15;
            return;
        L9:
            throw new DescriptorValidationException(this, TokenParser.DQUOTE + this.proto.getOutputType() + "\" is not a message type.", r14);
        L11:
            throw new DescriptorValidationException(this, TokenParser.DQUOTE + this.proto.getInputType() + "\" is not a message type.", r14);
        }

        private void setProto(DescriptorProtos.MethodDescriptorProto r10) {
            this.proto = r10;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        public int getIndex() {
            return this.index;
        }

        public Descriptor getInputType() {
            return this.inputType;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        public DescriptorProtos.MethodOptions getOptions() {
            return this.proto.getOptions();
        }

        public Descriptor getOutputType() {
            return this.outputType;
        }

        public ServiceDescriptor getService() {
            return this.service;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public /* bridge */ /* synthetic */ Message toProto() {
            return toProto();
        }

        private MethodDescriptor(DescriptorProtos.MethodDescriptorProto r10, FileDescriptor r11, ServiceDescriptor r12, int r13) throws DescriptorValidationException {
            this.index = r13;
            this.proto = r10;
            this.file = r11;
            this.service = r12;
            this.fullName = r12.getFullName() + '.' + r10.getName();
            FileDescriptor.access$1400(r11).addSymbol(this);
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.MethodDescriptorProto toProto() {
            return this.proto;
        }
    }

    public static final class OneofDescriptor {
        private Descriptor containingType;
        private int fieldCount;
        private FieldDescriptor[] fields;
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private DescriptorProtos.OneofDescriptorProto proto;

        public /* synthetic */ OneofDescriptor(DescriptorProtos.OneofDescriptorProto r10, FileDescriptor r11, Descriptor r12, int r13, AnonymousClass1 r14) throws DescriptorValidationException {
            this(r10, r11, r12, r13);
        }

        public static /* synthetic */ FieldDescriptor[] access$1800(OneofDescriptor r10) {
            return r10.fields;
        }

        public static /* synthetic */ FieldDescriptor[] access$1802(OneofDescriptor r10, FieldDescriptor[] r11) {
            r10.fields = r11;
            return r11;
        }

        public static /* synthetic */ int access$1902(OneofDescriptor r10, int r11) {
            r10.fieldCount = r11;
            return r11;
        }

        public static /* synthetic */ int access$1908(OneofDescriptor r10) {
            int r11 = r10.fieldCount;
            r10.fieldCount = r11 + 1;
            return r11;
        }

        public static /* synthetic */ void access$2000(OneofDescriptor r10, DescriptorProtos.OneofDescriptorProto r11) {
            r10.setProto(r11);
        }

        private void setProto(DescriptorProtos.OneofDescriptorProto r10) {
            this.proto = r10;
        }

        public Descriptor getContainingType() {
            return this.containingType;
        }

        public FieldDescriptor getField(int r10) {
            return this.fields[r10];
        }

        public int getFieldCount() {
            return this.fieldCount;
        }

        public List<FieldDescriptor> getFields() {
            return Collections.unmodifiableList(Arrays.asList(this.fields));
        }

        public FileDescriptor getFile() {
            return this.file;
        }

        public String getFullName() {
            return this.fullName;
        }

        public int getIndex() {
            return this.index;
        }

        public String getName() {
            return this.proto.getName();
        }

        public DescriptorProtos.OneofOptions getOptions() {
            return this.proto.getOptions();
        }

        private OneofDescriptor(DescriptorProtos.OneofDescriptorProto r10, FileDescriptor r11, Descriptor r12, int r13) throws DescriptorValidationException {
            this.proto = r10;
            this.fullName = Descriptors.access$1600(r11, r12, r10.getName());
            this.file = r11;
            this.index = r13;
            this.containingType = r12;
            this.fieldCount = 0;
        }
    }

    public static final class ServiceDescriptor extends GenericDescriptor {
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private MethodDescriptor[] methods;
        private DescriptorProtos.ServiceDescriptorProto proto;

        public /* synthetic */ ServiceDescriptor(DescriptorProtos.ServiceDescriptorProto r10, FileDescriptor r11, int r12, AnonymousClass1 r13) throws DescriptorValidationException {
            this(r10, r11, r12);
        }

        public static /* synthetic */ void access$1200(ServiceDescriptor r10, DescriptorProtos.ServiceDescriptorProto r11) {
            r10.setProto(r11);
        }

        public static /* synthetic */ void access$800(ServiceDescriptor r10) throws DescriptorValidationException {
            r10.crossLink();
        }

        private void crossLink() throws DescriptorValidationException {
            MethodDescriptor[] r10 = this.methods;
            int r11 = r10.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L5;
            MethodDescriptor.access$2900(r10[r12]);
            r12 = r12 + 1;
            goto L3
        }

        private void setProto(DescriptorProtos.ServiceDescriptorProto r10) {
            this.proto = r10;
            int r11 = 0;
        L3:
            MethodDescriptor[] r12 = this.methods;
            if (r11 >= r12.length) goto L6;
            MethodDescriptor.access$3000(r12[r11], r10.getMethod(r11));
            r11 = r11 + 1;
            goto L3
        }

        public MethodDescriptor findMethodByName(String r10) {
            GenericDescriptor r11 = FileDescriptor.access$1400(this.file).findSymbol(this.fullName + '.' + r10);
            if (r11 != null) goto L5;
            return null;
        L5:
            if ((r11 instanceof MethodDescriptor) == true) goto L7;
            return null;
        L7:
            return (MethodDescriptor) r11;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        public int getIndex() {
            return this.index;
        }

        public List<MethodDescriptor> getMethods() {
            return Collections.unmodifiableList(Arrays.asList(this.methods));
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        public DescriptorProtos.ServiceOptions getOptions() {
            return this.proto.getOptions();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public /* bridge */ /* synthetic */ Message toProto() {
            return toProto();
        }

        private ServiceDescriptor(DescriptorProtos.ServiceDescriptorProto r10, FileDescriptor r11, int r12) throws DescriptorValidationException {
            this.index = r12;
            this.proto = r10;
            this.fullName = Descriptors.access$1600(r11, null, r10.getName());
            this.file = r11;
            this.methods = new MethodDescriptor[r10.getMethodCount()];
            int r13 = 0;
        L4:
            if (r13 >= r10.getMethodCount()) goto L6;
            int r14 = r13;
            this.methods[r13] = new MethodDescriptor(r10.getMethod(r13), r11, this, r14, null);
            r13 = r13 + 1;
            goto L4
        L6:
            FileDescriptor.access$1400(r11).addSymbol(this);
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.ServiceDescriptorProto toProto() {
            return this.proto;
        }
    }

    static {
        logger = Logger.getLogger(Descriptors.class.getName());
    }

    public Descriptors() {
    }

    public static /* synthetic */ Logger access$100() {
        return logger;
    }

    public static /* synthetic */ String access$1600(FileDescriptor r10, Descriptor r11, String r12) {
        return computeFullName(r10, r11, r12);
    }

    private static String computeFullName(FileDescriptor r10, Descriptor r11, String r12) {
        if (r11 == null) goto L7;
        return r11.getFullName() + '.' + r12;
    L7:
        if (r10.getPackage().length() > 0) goto L9;
        return r12;
    L9:
        return r10.getPackage() + '.' + r12;
    }
}
