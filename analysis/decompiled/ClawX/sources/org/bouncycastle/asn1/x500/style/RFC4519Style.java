package org.bouncycastle.asn1.x500.style;

import java.util.Hashtable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import m0.f;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameStyle;

/* loaded from: classes.dex */
public class RFC4519Style extends AbstractX500NameStyle {
    private static final Hashtable DefaultLookUp;
    private static final Hashtable DefaultSymbols;
    public static final X500NameStyle INSTANCE;
    public static final ASN1ObjectIdentifier businessCategory;

    /* renamed from: c, reason: collision with root package name */
    public static final ASN1ObjectIdentifier f4354c;
    public static final ASN1ObjectIdentifier cn;
    public static final ASN1ObjectIdentifier dc;
    public static final ASN1ObjectIdentifier description;
    public static final ASN1ObjectIdentifier destinationIndicator;
    public static final ASN1ObjectIdentifier distinguishedName;
    public static final ASN1ObjectIdentifier dnQualifier;
    public static final ASN1ObjectIdentifier enhancedSearchGuide;
    public static final ASN1ObjectIdentifier facsimileTelephoneNumber;
    public static final ASN1ObjectIdentifier generationQualifier;
    public static final ASN1ObjectIdentifier givenName;
    public static final ASN1ObjectIdentifier houseIdentifier;
    public static final ASN1ObjectIdentifier initials;
    public static final ASN1ObjectIdentifier internationalISDNNumber;

    /* renamed from: l, reason: collision with root package name */
    public static final ASN1ObjectIdentifier f4355l;
    public static final ASN1ObjectIdentifier member;
    public static final ASN1ObjectIdentifier name;

    /* renamed from: o, reason: collision with root package name */
    public static final ASN1ObjectIdentifier f4356o;
    public static final ASN1ObjectIdentifier ou;
    public static final ASN1ObjectIdentifier owner;
    public static final ASN1ObjectIdentifier physicalDeliveryOfficeName;
    public static final ASN1ObjectIdentifier postOfficeBox;
    public static final ASN1ObjectIdentifier postalAddress;
    public static final ASN1ObjectIdentifier postalCode;
    public static final ASN1ObjectIdentifier preferredDeliveryMethod;
    public static final ASN1ObjectIdentifier registeredAddress;
    public static final ASN1ObjectIdentifier roleOccupant;
    public static final ASN1ObjectIdentifier searchGuide;
    public static final ASN1ObjectIdentifier seeAlso;
    public static final ASN1ObjectIdentifier serialNumber;
    public static final ASN1ObjectIdentifier sn;
    public static final ASN1ObjectIdentifier st;
    public static final ASN1ObjectIdentifier street;
    public static final ASN1ObjectIdentifier telephoneNumber;
    public static final ASN1ObjectIdentifier teletexTerminalIdentifier;
    public static final ASN1ObjectIdentifier telexNumber;
    public static final ASN1ObjectIdentifier title;
    public static final ASN1ObjectIdentifier uid;
    public static final ASN1ObjectIdentifier uniqueMember;
    public static final ASN1ObjectIdentifier userPassword;
    public static final ASN1ObjectIdentifier x121Address;
    public static final ASN1ObjectIdentifier x500UniqueIdentifier;
    protected final Hashtable defaultSymbols = AbstractX500NameStyle.copyHashTable(DefaultSymbols);
    protected final Hashtable defaultLookUp = AbstractX500NameStyle.copyHashTable(DefaultLookUp);

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifierI = f.i("2.5.4.15");
        businessCategory = aSN1ObjectIdentifierI;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI2 = f.i("2.5.4.6");
        f4354c = aSN1ObjectIdentifierI2;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI3 = f.i("2.5.4.3");
        cn = aSN1ObjectIdentifierI3;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI4 = f.i("0.9.2342.19200300.100.1.25");
        dc = aSN1ObjectIdentifierI4;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI5 = f.i("2.5.4.13");
        description = aSN1ObjectIdentifierI5;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI6 = f.i("2.5.4.27");
        destinationIndicator = aSN1ObjectIdentifierI6;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI7 = f.i("2.5.4.49");
        distinguishedName = aSN1ObjectIdentifierI7;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI8 = f.i("2.5.4.46");
        dnQualifier = aSN1ObjectIdentifierI8;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI9 = f.i("2.5.4.47");
        enhancedSearchGuide = aSN1ObjectIdentifierI9;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI10 = f.i("2.5.4.23");
        facsimileTelephoneNumber = aSN1ObjectIdentifierI10;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI11 = f.i("2.5.4.44");
        generationQualifier = aSN1ObjectIdentifierI11;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI12 = f.i("2.5.4.42");
        givenName = aSN1ObjectIdentifierI12;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI13 = f.i("2.5.4.51");
        houseIdentifier = aSN1ObjectIdentifierI13;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI14 = f.i("2.5.4.43");
        initials = aSN1ObjectIdentifierI14;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI15 = f.i("2.5.4.25");
        internationalISDNNumber = aSN1ObjectIdentifierI15;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI16 = f.i("2.5.4.7");
        f4355l = aSN1ObjectIdentifierI16;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI17 = f.i("2.5.4.31");
        member = aSN1ObjectIdentifierI17;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI18 = f.i("2.5.4.41");
        name = aSN1ObjectIdentifierI18;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI19 = f.i("2.5.4.10");
        f4356o = aSN1ObjectIdentifierI19;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI20 = f.i("2.5.4.11");
        ou = aSN1ObjectIdentifierI20;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI21 = f.i("2.5.4.32");
        owner = aSN1ObjectIdentifierI21;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI22 = f.i("2.5.4.19");
        physicalDeliveryOfficeName = aSN1ObjectIdentifierI22;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI23 = f.i("2.5.4.16");
        postalAddress = aSN1ObjectIdentifierI23;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI24 = f.i("2.5.4.17");
        postalCode = aSN1ObjectIdentifierI24;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI25 = f.i("2.5.4.18");
        postOfficeBox = aSN1ObjectIdentifierI25;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI26 = f.i("2.5.4.28");
        preferredDeliveryMethod = aSN1ObjectIdentifierI26;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI27 = f.i("2.5.4.26");
        registeredAddress = aSN1ObjectIdentifierI27;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI28 = f.i("2.5.4.33");
        roleOccupant = aSN1ObjectIdentifierI28;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI29 = f.i("2.5.4.14");
        searchGuide = aSN1ObjectIdentifierI29;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI30 = f.i("2.5.4.34");
        seeAlso = aSN1ObjectIdentifierI30;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI31 = f.i("2.5.4.5");
        serialNumber = aSN1ObjectIdentifierI31;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI32 = f.i("2.5.4.4");
        sn = aSN1ObjectIdentifierI32;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI33 = f.i("2.5.4.8");
        st = aSN1ObjectIdentifierI33;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI34 = f.i("2.5.4.9");
        street = aSN1ObjectIdentifierI34;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI35 = f.i("2.5.4.20");
        telephoneNumber = aSN1ObjectIdentifierI35;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI36 = f.i("2.5.4.22");
        teletexTerminalIdentifier = aSN1ObjectIdentifierI36;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI37 = f.i("2.5.4.21");
        telexNumber = aSN1ObjectIdentifierI37;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI38 = f.i("2.5.4.12");
        title = aSN1ObjectIdentifierI38;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI39 = f.i("0.9.2342.19200300.100.1.1");
        uid = aSN1ObjectIdentifierI39;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI40 = f.i("2.5.4.50");
        uniqueMember = aSN1ObjectIdentifierI40;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI41 = f.i("2.5.4.35");
        userPassword = aSN1ObjectIdentifierI41;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI42 = f.i("2.5.4.24");
        x121Address = aSN1ObjectIdentifierI42;
        ASN1ObjectIdentifier aSN1ObjectIdentifierI43 = f.i("2.5.4.45");
        x500UniqueIdentifier = aSN1ObjectIdentifierI43;
        Hashtable hashtable = new Hashtable();
        DefaultSymbols = hashtable;
        Hashtable hashtable2 = new Hashtable();
        DefaultLookUp = hashtable2;
        hashtable.put(aSN1ObjectIdentifierI, "businessCategory");
        hashtable.put(aSN1ObjectIdentifierI2, "c");
        hashtable.put(aSN1ObjectIdentifierI3, "cn");
        hashtable.put(aSN1ObjectIdentifierI4, "dc");
        hashtable.put(aSN1ObjectIdentifierI5, "description");
        hashtable.put(aSN1ObjectIdentifierI6, "destinationIndicator");
        hashtable.put(aSN1ObjectIdentifierI7, "distinguishedName");
        hashtable.put(aSN1ObjectIdentifierI8, "dnQualifier");
        hashtable.put(aSN1ObjectIdentifierI9, "enhancedSearchGuide");
        hashtable.put(aSN1ObjectIdentifierI10, "facsimileTelephoneNumber");
        hashtable.put(aSN1ObjectIdentifierI11, "generationQualifier");
        hashtable.put(aSN1ObjectIdentifierI12, "givenName");
        hashtable.put(aSN1ObjectIdentifierI13, "houseIdentifier");
        hashtable.put(aSN1ObjectIdentifierI14, "initials");
        hashtable.put(aSN1ObjectIdentifierI15, "internationalISDNNumber");
        hashtable.put(aSN1ObjectIdentifierI16, "l");
        hashtable.put(aSN1ObjectIdentifierI17, "member");
        hashtable.put(aSN1ObjectIdentifierI18, "name");
        hashtable.put(aSN1ObjectIdentifierI19, "o");
        hashtable.put(aSN1ObjectIdentifierI20, "ou");
        hashtable.put(aSN1ObjectIdentifierI21, "owner");
        hashtable.put(aSN1ObjectIdentifierI22, "physicalDeliveryOfficeName");
        hashtable.put(aSN1ObjectIdentifierI23, "postalAddress");
        hashtable.put(aSN1ObjectIdentifierI24, "postalCode");
        hashtable.put(aSN1ObjectIdentifierI25, "postOfficeBox");
        hashtable.put(aSN1ObjectIdentifierI26, "preferredDeliveryMethod");
        hashtable.put(aSN1ObjectIdentifierI27, "registeredAddress");
        hashtable.put(aSN1ObjectIdentifierI28, "roleOccupant");
        hashtable.put(aSN1ObjectIdentifierI29, "searchGuide");
        hashtable.put(aSN1ObjectIdentifierI30, "seeAlso");
        hashtable.put(aSN1ObjectIdentifierI31, "serialNumber");
        hashtable.put(aSN1ObjectIdentifierI32, "sn");
        hashtable.put(aSN1ObjectIdentifierI33, "st");
        hashtable.put(aSN1ObjectIdentifierI34, "street");
        hashtable.put(aSN1ObjectIdentifierI35, "telephoneNumber");
        hashtable.put(aSN1ObjectIdentifierI36, "teletexTerminalIdentifier");
        hashtable.put(aSN1ObjectIdentifierI37, "telexNumber");
        hashtable.put(aSN1ObjectIdentifierI38, "title");
        hashtable.put(aSN1ObjectIdentifierI39, "uid");
        hashtable.put(aSN1ObjectIdentifierI40, "uniqueMember");
        hashtable.put(aSN1ObjectIdentifierI41, "userPassword");
        hashtable.put(aSN1ObjectIdentifierI42, "x121Address");
        hashtable.put(aSN1ObjectIdentifierI43, "x500UniqueIdentifier");
        hashtable2.put("businesscategory", aSN1ObjectIdentifierI);
        hashtable2.put("c", aSN1ObjectIdentifierI2);
        hashtable2.put("cn", aSN1ObjectIdentifierI3);
        hashtable2.put("dc", aSN1ObjectIdentifierI4);
        hashtable2.put("description", aSN1ObjectIdentifierI5);
        hashtable2.put("destinationindicator", aSN1ObjectIdentifierI6);
        hashtable2.put("distinguishedname", aSN1ObjectIdentifierI7);
        hashtable2.put("dnqualifier", aSN1ObjectIdentifierI8);
        hashtable2.put("enhancedsearchguide", aSN1ObjectIdentifierI9);
        hashtable2.put("facsimiletelephonenumber", aSN1ObjectIdentifierI10);
        hashtable2.put("generationqualifier", aSN1ObjectIdentifierI11);
        hashtable2.put("givenname", aSN1ObjectIdentifierI12);
        hashtable2.put("houseidentifier", aSN1ObjectIdentifierI13);
        hashtable2.put("initials", aSN1ObjectIdentifierI14);
        hashtable2.put("internationalisdnnumber", aSN1ObjectIdentifierI15);
        hashtable2.put("l", aSN1ObjectIdentifierI16);
        hashtable2.put("member", aSN1ObjectIdentifierI17);
        hashtable2.put("name", aSN1ObjectIdentifierI18);
        hashtable2.put("o", aSN1ObjectIdentifierI19);
        hashtable2.put("ou", aSN1ObjectIdentifierI20);
        hashtable2.put("owner", aSN1ObjectIdentifierI21);
        hashtable2.put("physicaldeliveryofficename", aSN1ObjectIdentifierI22);
        hashtable2.put("postaladdress", aSN1ObjectIdentifierI23);
        hashtable2.put("postalcode", aSN1ObjectIdentifierI24);
        hashtable2.put("postofficebox", aSN1ObjectIdentifierI25);
        hashtable2.put("preferreddeliverymethod", aSN1ObjectIdentifierI26);
        hashtable2.put("registeredaddress", aSN1ObjectIdentifierI27);
        hashtable2.put("roleoccupant", aSN1ObjectIdentifierI28);
        hashtable2.put("searchguide", aSN1ObjectIdentifierI29);
        hashtable2.put("seealso", aSN1ObjectIdentifierI30);
        hashtable2.put("serialnumber", aSN1ObjectIdentifierI31);
        hashtable2.put("sn", aSN1ObjectIdentifierI32);
        hashtable2.put("st", aSN1ObjectIdentifierI33);
        hashtable2.put("street", aSN1ObjectIdentifierI34);
        hashtable2.put("telephonenumber", aSN1ObjectIdentifierI35);
        hashtable2.put("teletexterminalidentifier", aSN1ObjectIdentifierI36);
        hashtable2.put("telexnumber", aSN1ObjectIdentifierI37);
        hashtable2.put("title", aSN1ObjectIdentifierI38);
        hashtable2.put("uid", aSN1ObjectIdentifierI39);
        hashtable2.put("uniquemember", aSN1ObjectIdentifierI40);
        hashtable2.put("userpassword", aSN1ObjectIdentifierI41);
        hashtable2.put("x121address", aSN1ObjectIdentifierI42);
        hashtable2.put("x500uniqueidentifier", aSN1ObjectIdentifierI43);
        INSTANCE = new RFC4519Style();
    }

    @Override // org.bouncycastle.asn1.x500.X500NameStyle
    public ASN1ObjectIdentifier attrNameToOID(String str) {
        return IETFUtils.decodeAttrName(str, this.defaultLookUp);
    }

    @Override // org.bouncycastle.asn1.x500.style.AbstractX500NameStyle
    public ASN1Encodable encodeStringValue(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        return aSN1ObjectIdentifier.equals((ASN1Primitive) dc) ? new DERIA5String(str) : (aSN1ObjectIdentifier.equals((ASN1Primitive) f4354c) || aSN1ObjectIdentifier.equals((ASN1Primitive) serialNumber) || aSN1ObjectIdentifier.equals((ASN1Primitive) dnQualifier) || aSN1ObjectIdentifier.equals((ASN1Primitive) telephoneNumber)) ? new DERPrintableString(str) : super.encodeStringValue(aSN1ObjectIdentifier, str);
    }

    @Override // org.bouncycastle.asn1.x500.X500NameStyle
    public RDN[] fromString(String str) {
        RDN[] rdnArrRDNsFromString = IETFUtils.rDNsFromString(str, this);
        RDN[] rdnArr = new RDN[rdnArrRDNsFromString.length];
        for (int i8 = 0; i8 != rdnArrRDNsFromString.length; i8++) {
            rdnArr[(r5 - i8) - 1] = rdnArrRDNsFromString[i8];
        }
        return rdnArr;
    }

    @Override // org.bouncycastle.asn1.x500.X500NameStyle
    public String[] oidToAttrNames(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return IETFUtils.findAttrNamesForOID(aSN1ObjectIdentifier, this.defaultLookUp);
    }

    @Override // org.bouncycastle.asn1.x500.X500NameStyle
    public String oidToDisplayName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (String) this.defaultSymbols.get(aSN1ObjectIdentifier);
    }

    @Override // org.bouncycastle.asn1.x500.X500NameStyle
    public String toString(X500Name x500Name) {
        StringBuilder sb = new StringBuilder();
        RDN[] rDNs = x500Name.getRDNs();
        boolean z = true;
        for (int length = rDNs.length - 1; length >= 0; length--) {
            if (z) {
                z = false;
            } else {
                sb.append(AbstractJsonLexerKt.COMMA);
            }
            IETFUtils.appendRDN(sb, rDNs[length], this.defaultSymbols);
        }
        return sb.toString();
    }
}
